import React, { useMemo, useState } from 'react';

//평균 구하는 함수
const getAverage = (numbers) => {
    console.log('getAverage() 호출됨');
    if (numbers.length === 0)
        return 0;
    const sum = numbers.reduce((a, b) => a + b, 0); //reduce()를 이용해서 합계 구하기
    return sum / numbers.length;
}

const SixAverage = () => {
    const [list, setList] = useState([]);
    const [number, setNumber] = useState(0);

    const avg= useMemo(()=>getAverage(list),[list]); //평균 구하는 함수 호출

    return (
        <div>
            <h5>숫자를 입력하면 입력한 숫자에 대한 평균 구하기</h5>
            <input type='text' value={number}
            onChange={(e) => setNumber(e.target.value)}/>
            <button onClick={() => {
                setList(list.concat(Number(number))); //배열추가시 concat 사용
                setNumber('');
            }}>추가</button>
            <br/><br/>
            <ul>
            {
                list.map((num, idx)=>
                    <li key={idx}>{num}</li>
                )
            }
            </ul>
            <div style={{fontSize:'2em', margin:'10px'}}>
                평균 : {avg}
            </div>
        </div>
    );
};

export default SixAverage;