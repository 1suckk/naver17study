//초창기 컴포넌트는 모두 클래스 형태였다
//Hooks 문법이 리액트 16.8에서 새로 도입되면서 일반 함수형태로 변경
//초기 함수형태는 상태저장을 하는 state 기능이 없었는데
//Hooks 문법이 추가된 이후부터 일반 함수에서도 상태유지를 위한 state 기능이 추가되었다
//클래스에서는 라이프 사이클이 엄청 복잡했었는데 Hooks 문법 이후 라이프 사이클도 엄청 단순해졌다

import { Component } from "react";
import ray from "./01_ray.png";
//리턴 안에있는 구문들은 html 태그가 아니라 jsx 태그이다

//html 과 jsx의 차이점
//1. 모든 요소는 짝이 맞아야 한다 (br같은 태그도 마찬가지!)
//2. 특성 이름이 html 언어 사양이 아닌 dom api 에 기반을 둔다
//첫예제 클래스로 만들어보자
class OneApp extends Component
{
    // constructor(){
    //     //생성자는 클래스명과 상관없이 무조건 constructor
    // }

    render(){
        return (
            //return 안에서는 하나의 div만 가능
            //태그 안에서 직접 스타일을 추가하는 방법
            <div>
                <h2>기아 ray EV</h2>
                <br/>
                {/* public 의 이미지 나타내는 방법 - 경로로 가능 - 권장안함 */}
                <img alt="" className="photo1" src={ray} />
            </div>
        )
    }
}

// export {OneApp} //여러번 사용가능, import 할때 {OneApp} 으로만 import 가능
export default OneApp; //default 는 단 한번만 사용이 가능