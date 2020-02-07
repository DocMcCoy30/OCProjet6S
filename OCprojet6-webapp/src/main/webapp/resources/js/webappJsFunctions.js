function lougOutFormSubmit() {
    document.getElementById("logoutForm").submit();
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
function searchSitePopulate(optionRef) {
    document.getElementById('optionRef').value=optionRef;
    document.getElementById('searchSitesForm').submit();
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
