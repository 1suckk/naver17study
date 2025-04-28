import React, { useState } from "react";

const ThreeApp = () => {
    let msg = "가격: 2천만원";
    const [number, setNumber] = useState(0);
    //통장번호를 저장할 변수
    const [accountNumber,setAccountNumber]=useState("(예시)111-111-1111");

    return (
        <div>
            <h2>주문 수량을 입력하세요.</h2>
            <button type="button" className="btn btn-danger"
            onClick={()=>{
                if(number>0)
                    setNumber(number-1);
            }}>
                감소
            </button>&nbsp;&nbsp;
            <button type="button" className="btn btn-info"
            onClick={()=>{
                if(number<10)
                    setNumber(number+1)
            }}>
                증가</button>
            <br/>
            <b className="numstyle">{number}</b>
            <hr/>
            <input type="text" className="form-control"
            placeholder="계좌번호를 입력하세요"
            onChange={(e)=>setAccountNumber(e.target.value)}/>
            <br/>
            <h3>{accountNumber}</h3>
        </div>
    );

    
};

export default ThreeApp;