function showComments() {
    $.ajax({
        //Get comment html code
        url: "http://localhost:8080/api/test",
        method: "GET",
        success: function (response) {
            $('#showComments').html(response);
        }
    })
}