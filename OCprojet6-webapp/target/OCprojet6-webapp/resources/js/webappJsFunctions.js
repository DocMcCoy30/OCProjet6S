/**
 * Affiche le formulaire d'upload d'images
 * @param a
 */
function showFormUpload(a) {
    if (a == 1) {
        document.getElementById("formUpload").style.display = "block";
    } else {
        document.getElementById("formUpload").style.display = "none";
    }
}
function showUploadMsg (msg) {
document.getElementById('uploadMsg').innerHTML=msg;
    setTimeout(function() {document.getElementById('uploadMsg').innerHTML='';},5000);}
