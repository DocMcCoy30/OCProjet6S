$('#regionC').change(function (response) {
    $.ajax({
        url: 'autoPopulateDepartements',
        type: 'GET',
        data: {region: $(this).val()},
        // dataType: "json",
        success: function (data) {
            document.getElementById('departementC').options.length = 0;
            for (let i = 0; i < data.length; i++) {
                let code = parseInt(data[i].code);
                let nom = data[i].nom;
                $('#departementC').append('<option value="' + code + '">' + nom + '</option>');
            }
        }
    });
});


