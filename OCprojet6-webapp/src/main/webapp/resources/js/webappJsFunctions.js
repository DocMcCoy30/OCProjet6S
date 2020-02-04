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

/**
 * Affiche le message d'upload
 * @param msg
 */
function showUploadMsg (msg) {
    document.getElementById('uploadMsg').innerHTML=msg;
    setTimeout(function() {document.getElementById('uploadMsg').innerHTML='';},5000);}

/**
 *
 */
function showFileName() {
    var fileName = (this).val();
    this.next('.custom-file-label').html(fileName);
}