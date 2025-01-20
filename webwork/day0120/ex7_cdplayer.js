$(function(){
    //h1.title을 클릭 시 .music-list를 slidedown 효과
    $("h1.title").click(function(){
        $("ul.music-list").slideDown('slow');
    });

    //노래제목 믈릭시 이벤트
    $("ul.music-list li").click(function(){
        //노래제목 얻기
        let title = $(this).text();
        
        //h1.title에 넣기
        $("h1.title").text(title);

        //클릭한 곳의 class 얻기
        let selectedClass = $(this).attr("class");

        //앨범 이미지를 변경
        let imgSrc = "../jquery_image/jannabi.png"; //기본 이미지
        if (selectedClass == "music2") {
            imgSrc = "../jquery_image/yoasobi.png";
        } else if (selectedClass == "music3") {
            imgSrc = "../jquery_image/standingegg.png";
        }
        $("img.cover").attr("src", imgSrc);

        //음악 소스 변경
        let audSrc = "";
        if (selectedClass == "music1") {
            audSrc = "../jquery_image/JANNABI - For Lovers Who Hesitate.mp3";
        } else if (selectedClass == "music2"){
            audSrc = "../jquery_image/Yoasobi - tabun.mp3";
        } else if (selectedClass == "music3") {
            audSrc = "../jquery_image/StandingEgg - Old song.mp3";
        }

        $("#audioPlayer").attr("src", audSrc);
        $("#audioPlayer")[0].play();

        //마지막에 노래목록 slideup
        $("ul.music-list").slideUp('slow');

        // 노래 재생 시작 및 CD 회전
        $("#audioPlayer")[0].play();
        $("#cd").addClass("spinning");
    });

    $("#cd").click(function(){
        var audio = $("#audioPlayer")[0];
        if (audio.paused) {
            audio.play();
            $(this).addClass("spinning");
        } else {
            audio.pause();
            $(this).removeClass("spinning");
        }

        
    });    

});