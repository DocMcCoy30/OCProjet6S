/**
 * Gère la deconnexion de l'utilisateur.
 */
function lougOutFormSubmit() {
    document.getElementById("logoutForm").submit();
}

/**
 * Autocomplétion de la barre de recherche.
 */
$("#searchInput").autocomplete({
    source: function (request, response) {
        $.ajax({
            url: "AutocompleteController",
            type: "GET",
            data: {
                term: request.term
            },
            dataType: "json",
            success: function (data) {
                response(data);
            }
        });
    },
});

$('#site-container').ready(function () {
    let officiel = $('#var-macaron').val();
    console.log(officiel);
    if (officiel==='false') {
        $('#attribut-officiel').css('display', 'none');
        console.log(officiel + " : Le site n'est pas officiel")
    }
    else {
        $('#attribut-officiel').css('display', 'block');
        console.log(officiel + " : Le site est Officiel")
    }
});

/**
 * Gestion de l'option pour rendre un site officiel : modifie la valeur officiel dans la base de données selon
 * que la checkbox ext cochée ou non.
 */
$('#officiel').click(function () {
    let checked = $(this).is(':checked');
    let siteId = $(this).val();
    $.ajax({
        url: 'rendreOfficiel',
        type: 'POST',
        data: { 'siteId': siteId, 'checked':checked } ,
        dataType: "json",
        success: function (data) {
            let site = data;
            if (site.officiel) {
                $('#attribut-officiel').css('display', 'block')
            }
            else {
                $('#attribut-officiel').css('display', 'none')
            }
            console.log(site);
        }
    });
});

/**
 * Gère les liste de choix de recherche de sites dans le formulaire de recherche multicritères
 * @param optionRef
 */
function searchSitePopulate(optionRef) {
    document.getElementById('optionRef').value = optionRef;
    document.getElementById('searchSitesForm').submit();
}

/**
 * Gère la liste des départements en fonction de la région choisie dans le formulaire de création de site
 */
$('#region').change(function (response) {
    $.ajax({
        url: 'autoPopulateDepartements',
        type: 'GET',
        data: {region: $(this).val()},
        // dataType: "json",
        success: function (data) {
            document.getElementById('departement').options.length = 0;
            for (let i = 0; i < data.length; i++) {
                let code = parseInt(data[i].code);
                let nom = data[i].nom;
                $('#departement').append('<option value="' + code + '">' + nom + '</option>');
            }
        }
    });
});

/**
 * Affiche le formulaire d'upload d'images lorsque le bouton "ajouter une photo" est cliqué.
 * @param a
 */
function showFormUpload(a) {
    if (a === 1) {
        document.getElementById("formUpload").style.display = "block";
    } else {
        document.getElementById("formUpload").style.display = "none";
    }
}

/**
 * Affiche le formulaire d'ajout de topo lorsque le bouton "ajouter" est cliqué.
 * @param a
 */
function showTopoForm(a) {
    if (a === 1) {
        document.getElementById("topoForm").style.display = "block";
    } else {
        document.getElementById("topoForm").style.display = "none";
    }
}

/**
 * Affiche le message d'upload pendant 5s et l'efface : !fonctionnel
 * @param msg
 */
function showUploadMsg(msg) {
    document.getElementById('uploadMsg').innerHTML = msg;
    setTimeout(function () {
        document.getElementById('uploadMsg').innerHTML = '';
    }, 5000);
}

/**
 * Récupère le nom de la photo selectionnée et l'affiche dans l'input : !fonctionnel
 */
function showFileName() {
    const fileName = (this).val();
    this.next('.custom-file-label').html(fileName);
}

