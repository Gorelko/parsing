function showresult() {

    var uploadFile = document.getElementById("uploadFileEnd").value;

    var siteSelect = document.getElementById("siteSelect").value;

    if (uploadFile == '' || siteSelect == '') {

        location.reload();
        document.location.href = "http://localhost:8383/projectparsing_war/index.html";
        alert("Please enter all the information !!!");

    }

}


window.onload = function () {
    Particles.init
    ({

// normal options
        selector: '.background', maxParticles: 500,  // options for breakpoints
        color: '#75A5B7',
        responsive: [
            {
                breakpoint: 7686,
                options: {
                    maxParticles: 200, color: '#48F2E3', connectParticles: false
                }
            }, {
                breakpoint: 2000
                ,
                options: {
                    maxParticles: 120
                    ,
                    connectParticles: true
                }
            }, {
                breakpoint: 320
                ,
                options: {
                    maxParticles: 0

// disables particles.js
                }
            }
        ]
    });
};