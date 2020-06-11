$(function() {
    $('input[name="employeeoperation"]').on('click', function() {
        if ($(this).val() == 'selectsingleemp') {
            $('#textboxes').show();
        }
        else {
            $('#textboxes').hide();
        }
    });
});
/*$("body").delegate("#datepicker", "focusin", function () {
    $(this).datepicker();
});*/
/*$(function() {
    $( "#datepicker" ).datepicker({
        dateFormat : 'dd/mm/yy',
         changeMonth : true,
         changeYear : true,
         yearRange: '-110y:c+nn',
         maxDate: '-1d'
    });
});*/
