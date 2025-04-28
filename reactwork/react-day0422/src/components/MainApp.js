import React, { useState } from 'react';
import Purchase_car from './Purchase_car';
import InsuranceContract from './InsuranceContract';
import Councel from './Councel';
import FourApp from './carReview';
import FiveApp from './FiveApp';
import SixApp from './lawQuiz';
import SevenApp from './taxSearch';
import EightApp from './shopSearch';


const MainApp = () => {
    //메뉴 인덱스
    const [idx, setIdx] = useState(1);

    //radio event
    const selMenu = (e) => {
        setIdx(Number(e.target.value));
    }

    return (
        <div>
            <h3 className='alert alert-danger'>비트카센터</h3>
            <label>
                <input type='radio' defaultValue={1} name='selMenu'
                onClick={selMenu}/>차량구매
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={2} name='selMenu'
                onClick={selMenu}/>자동차보험 가입
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={3} name='selMenu'
                onClick={selMenu}/>온라인 상담 받기
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={4} name='selMenu'
                onClick={selMenu}/>서비스 소개
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={5} name='selMenu'
                onClick={selMenu}/>5번 페이지
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={6} name='selMenu'
                onClick={selMenu}/>자동차 법률지식 퀴즈
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={7} name='selMenu'
                onClick={selMenu}/>자동차 세금 조회
            </label>
            &nbsp;&nbsp;
            <label>
                <input type='radio' defaultValue={8} name='selMenu'
                onClick={selMenu}/>지점 검색하기
            </label>
            <div style={{marginTop:'20px'}}>
                {idx===1?<Purchase_car/>:idx===2?<InsuranceContract/>:idx===3?<Councel/>:
                idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>:idx===7?<SevenApp/>:
                <EightApp/>}
            </div>
        </div>
    );
};

export default MainApp;