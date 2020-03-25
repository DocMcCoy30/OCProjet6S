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
    if (officiel === 'false') {
        $('#attribut-officiel').css('display', 'none');
    } else {
        $('#attribut-officiel').css('display', 'block');
    }
});

/**
 * Gestion de l'option pour rendre un site officiel : modifie la valeur officiel dans la base de données selon
 * que la checkbox est cochée ou non.
 */
$('#officiel').click(function () {
    let checked = $(this).is(':checked');
    let siteId = $(this).val();
    $.ajax({
        url: 'rendreOfficiel',
        type: 'POST',
        data: {'siteId': siteId, 'checked': checked},
        dataType: "json",
        success: function (data) {
            let site = data;
            if (site.officiel) {
                $('#attribut-officiel').css('display', 'block')
            } else {
                $('#attribut-officiel').css('display', 'none')
            }
        }
    });
});

/**
 * Gestion de l'option de validation des commentaires pour l'administrateur : modifie la valeur 'valide' dans la base de données selon
 * que la checkbox est cochée ou non.
 */
$('#commentaire-panel input[type="checkbox"]').click(function () {
    let commentaireId = $(this).val();
    let checked = $(this).is(':checked');
    $.ajax({
        url: 'publierCommentaire',
        type: 'POST',
        data: {'commentaireId': commentaireId, 'checked': checked},
        dataType: "json",
        success: function (data) {
            let commentaire = data;
            if (commentaire.valide) {
                console.log("commentaire validé");
            } else {
                console.log("commentaire non validé");
            }
        }
    });
});

/**
 * Gestion de l'acceptation ou le refus des demandes de reservation de topos
 */
$('#reservation-panel input[type="radio"]').click(function () {
    let action= $(this).attr('id');
    console.log("reservationId = " + action);
    let reservationId = $(this).val();
    console.log("action = " + reservationId);
    $.ajax({
        url: 'updateTopoReservation',
        type: 'POST',
        data: {'reservationId': reservationId, 'action': action},
        dataType: 'json',
        success: function (data) {
            let reservation = data;
            if (reservation.valide) {
                console.log("reservation validée");
            } else {
                console.log("reservation validée");
            }
        }
    });
});

/**
 * Gère la modification de role de l'utilisateur dans la page personnelle des admin
 */
$('#userTable input[type="radio"]').click(function () {
    let username = $(this).val();
    let newRole = $(this).attr('id');
    console.log('User selectionné = '+username);
    console.log('newRole = ' + newRole);
    // if (newRole === 'ROLE_USER') {
        $.ajax({
            url: 'updateUserRole',
            method: 'POST',
            data: {'username': username, 'newRole': newRole},
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        })
    // } else if (checkboxName === 'administrateur') {
    //     newRole = 'ROLE_ADMIN';
    //     // console.log('Uncheck de #utilisateur demandée');
    //     // $('#utilisateur').attr('checked', false);
    //     $.ajax({
    //         url: 'updateUserRole',
    //         method: 'POST',
    //         data: {'username': username, 'newRole': newRole},
    //         dataType: 'json',
    //         success: function (data) {
    //             console.log(data);
    //             $('#utilisateur').prop('checked', false);
    //
    //         }
    //     })
    // }
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
    if (a !== 1) {
        $('#formUpload').css('display', 'none')
    } else {
        $('#formUpload').css('display', 'block')
    }
}

/**
 * Affiche le formulaire d'ajout de topo lorsque le bouton "ajouter" est cliqué.
 * @param b
 */
function showTopoForm(b) {
    if (b !== 1) {
        $('#topoForm').css('display', 'none')
    } else {
        $('#topoForm').css('display', 'block')
    }
}

/**
 * Affiche le panneau des commentaires lorsque le bouton "commentaire" est cliqué.
 * @param c
 */
function showCommentPanel(c) {
    if (c !== 1) {
        $('#commentaire-card').css('display', 'none')
    } else {
        showCommentaireForm(0)
        $('#commentaire-card').css('display', 'block')
    }
}

/**
 * Affiche le formulaire d'ajout de commentaire lorsque le bouton "ajouter" est cliqué.
 * @param d
 */
function showCommentaireForm(d) {
    if (d !== 1) {
        $('#commentaire-form').css('display', 'none')
    } else {
        showCommentPanel(0)
        $('#commentaire-form').css('display', 'block')
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

