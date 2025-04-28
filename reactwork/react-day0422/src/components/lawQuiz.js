import {Switch} from '@mui/material';
import React, { useState } from "react";

const SixApp = () => {
    const [visible, setVisible] = useState('visible');

    return (
        <div>
            <h3 className='alert alert-success'>자동차 법률지식 퀴즈</h3>
            
            <h4>
                답안 모두 확인
                <Switch defaultChecked color='info'
                onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            </h4>

            <h4>1. 자동차보험에서 대인보상은 선택 사항이다 : true or false</h4>
            <div style={{width:'200px',visibility:visible, border: '1px solid'}}>
                <h4>거짓입니다.</h4>
            </div>

            <h4>2. 자동차보험에서 대물보상은 1천만원 이상이면 상관없다 : true or false</h4>
            <div style={{width:'200px',visibility:visible, border: '1px solid'}}>
                <h4>거짓입니다.</h4>
            </div>
        </div>
    );
};

export default SixApp;