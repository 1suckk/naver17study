import React from 'react';
import {Alert} from '@mui/material';
import SixShowState from './SixShowState';
import SixAverage from './SixAverage';

const SixApp = () => {
    /* memorization : 렌더링을 최적화하기 위한 기능 */
    const [number, setNumber] = React.useState(0);
    const [text, setText] = React.useState('');
    
    //숫자 증가 함수
    const increNumber = () => {
        setNumber(number+1);
    }
    //숫자 감소 함수
    const decreNumber = () => {
        setNumber(number-1);
    }
    const onChangeTextHandler = (e) => {   
        setText(e.target.value);
    }


    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
            6번 페이지
            </Alert>
            <button onClick={increNumber}>증가</button>
            &nbsp;&nbsp;
            <button onClick={decreNumber}>감소</button>
            <br/><br/>
            <input type='text' placeholder='Last Name?'
            onChange={onChangeTextHandler}/>
            {/* 서브 컴포넌트 호출 */}
            <SixShowState number={number} text={text}/>
            <hr/>
            <SixAverage/>
        </div>
    );
};

export default SixApp;