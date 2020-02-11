/**
 * deconnection :fonctionnel
 */
function lougOutFormSubmit() {
    document.getElementById("logoutForm").submit();
}
//
// function inputSearchSubmit() {
//  document.getElementById('inputSearchForm').submit();
// }
$("#searchInput").autocomplete({
    source : function(request, response) {
        $.ajax({
            url : "AutocompleteController",
            type : "GET",
            data : {
                term : request.term
            },
            dataType : "json",
            success : function(data) {
                response(data);
            }
        });
    },
    // select: function( event, ui ) {
    //     alert( ui.item.value );
    //     // Your code
    //     return false;
    // }
});
function inputSearch () {
    var donnees = document.getElementById('searchInput');
    var url = "searchAll?valeur="+escape(donnees.value);
    requete=new XMLHttpRequest();
    requete.open("GET", url, true);
    requete.onreadystatechange = majIHM;
    requete.send(null);
}

/**
 * Gère les liste de choix de recherche de sites : fonctionnel
 * @param optionRef
 */
function searchSitePopulate(optionRef) {
    document.getElementById('optionRef').value=optionRef;
    document.getElementById('searchSitesForm').submit();
    // $('#optionRef').value=optionRef;
    // $('#searchSitesForm').submit();
}

/**
 * Affiche le formulaire d'upload d'images : fonctionnel
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
 * Affiche le message d'upload pendant 5s et l'efface : !fonctionnel
 * @param msg
 */
function showUploadMsg (msg) {
    document.getElementById('uploadMsg').innerHTML=msg;
    setTimeout(function() {document.getElementById('uploadMsg').innerHTML='';},5000);}

/**
 * Récupère le nom de la photo selectionnée et l'affiche dans l'input : !fonctionnel
 */
function showFileName() {
    const fileName = (this).val();
    this.next('.custom-file-label').html(fileName);
}

