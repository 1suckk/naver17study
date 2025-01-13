window.onload=function(){
    let mycar=document.querySelectorAll(".mycar");//배열타입

    //0번이미지 이벤트
    //마우스를 올리면 ../photo/K-052.png 떼면 복귀
    let oldphoto="";
    mycar[0].onmouseover=function() {
        //마우스가 위치한 곳의 이미지를 얻기
        oldphoto=this.getAttribute("src");
        console.log(oldphoto);
        //새로운 이미지로 변경
        this.setAttribute("src", "../photo/K-052.png");
    }
    mycar[0].onmouseout=function() {
        this.setAttribute("src", oldphoto);
    }

    //1번이미지 이벤트
    //마우스를 올리면 border를 알아서 설정 떼면 복귀
    mycar[1].onmouseover=function(){
        this.style.borderStyle="inset";
        this.style.borderWidth="10px";
        this.style.borderColor="green";
    }
    mycar[1].onmouseout=function(){
        this.style.border="none";
    }

    //2번이미지 이벤트
    //마우스를 올리면 .happy 적용 떼면 다시 없애
    //.happy는 미리 만들어둘것 (내용 자유)
    mycar[2].onmouseover=function(){
        this.setAttribute("class", "mycar happy");
    }
    mycar[2].onmouseout=function(){
        this.setAttribute("class", "mycar");
    }
}