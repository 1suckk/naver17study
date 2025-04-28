import React, { use, useMemo } from 'react';

const getNumber = (number) => {
    console.log('getNumber() 호출됨');
    return number;
}

const getText = (text) => {
    console.log('getText() 호출됨');
    return text;
}

const SixShowState = ({number, text}) => {
    //숫자가 바뀌어도 모든 함수가 호출
    //글자가 변경되어도 모든 함수가 호출
    const showNumber=useMemo(() => getNumber(number), [number]);
    const showText=useMemo(() => getText(text), [text]);

    return (
        <div style={{fontSize:'2px', margin:'20px'}}>
            {showNumber}<br/><br/>
            {showText}  
        </div>
    );
};

export default SixShowState;