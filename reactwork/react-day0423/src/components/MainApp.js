import {Alert} from '@mui/material';
import React, { useState } from 'react';
import Qna from './Qna';
import FinQuiz from './FinQuiz';
import CalCarTax from './CalCarTax';
import ShoppingMall from './ShoppingMall';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

const MainApp = () => {
    const [idx, setIdx] = useState(1);

    return (
        <div>
            <Alert severity='success'>비트드라이버캐피털::운전자를 위한 금융지원</Alert>
            <hr/>
            <div style={{width:'400px'}} className='input-group'>
                <i class="bi bi-list" style={{margin: '10px'}}></i>
                <select className='form-select' style={{margin:'10px'}}
                onChange={(e)=>{setIdx(Number(e.target.value))}}>
                    <option value={1}>쇼핑몰</option>
                    <option value={2}>관리자와 문의사항</option>
                    <option value={3}>대출 고객 리뷰 조회</option>
                    <option value={4}>차량 개소세 계산기</option>
                    <option value={5}>자동차 할부 대출 계산기</option>
                    <option value={6}>금융센터 지점 조회</option>
                    <option value={7}>임직원 정보공개</option>
                    <option value={8}>광고 페이지</option>
                </select>
            </div>
            {
                idx === 1 ? <ShoppingMall/> : idx === 2 ? <Qna/> : idx === 3 ? <FinQuiz/>
                :idx === 4 ? <CalCarTax/> : idx === 5 ? <FiveApp/> : idx === 6 ? <SixApp/>
                :idx === 7 ? <SevenApp/> : <EightApp/>
            }
        </div>
    );
};

export default MainApp;