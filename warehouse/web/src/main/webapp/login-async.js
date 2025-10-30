$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault();
        var $form = $(this);
        var url = $form.attr('action');
        var method = 'POST';
        var formData = $form.serialize();
        $.ajax({
            type: method,
            url: url,
            data: formData,
            dataType: 'json',
            success: function (data) {
                if(data.session.attributes.result){
                    window.location.href = "Secured/profile.html";
                }
                else {
                    alert("Érvénytelen belépési adatok!");
                }
            }
            })
    })
})