import React, {useState} from 'react';

/* 직급은 임원(대표이사, 전무이사), 직원(부장, 과장, 대리, 주임, 사원, 계약직)으로
구성이 된다. 그러나 임원과 부장은 이사회의 승인을 통해 본사에서 데이터베이스를 관리하므로 
전산시스템으로 입력이 불가하다. 그러므로 추가되는 직원은 과장, 대리, 주임, 사원, 계약직에 한정한다 */
const OneWriteForm = ({onSave}) => {
    const [irum, setIrum] = useState('');
    const [photo, setPhoto] = useState('1.jpg');
    const [rate, setRate] = useState('사원');
    const [Inyear, setInyear] = useState('2025');

    //추가 버튼 이벤트 함수
    const addEvent=()=>{
        onSave({irum,photo,rate,Inyear});
        //초기화
        setIrum("");
    }

    return (
        <div className='input-group'>
            <input type='text' className='form-control'
            placeholder='성명' value={irum}
            onChange={(e)=>setIrum(e.target.value)}/>

            <select className='form-select'
            onChange={(e)=>setPhoto(e.target.value)}>
            {
                [...new Array(10)].map((_,idx)=>
                    <option key={idx}>{idx+1}.jpg</option>)
            }
            </select>

            <select className='form-select'
            onChange={(e)=>setRate(e.target.value)}>
                <option>과장</option>
                <option>대리</option>
                <option>주임</option>
                <option>사원</option>
                <option>계약직</option>
            </select>
            <input type='text' placeholder='성명'
            value={Inyear}
            onChange={(e)=>setInyear(e.target.value)}/>
            <button className='btn btn-success'
            onClick={addEvent}>
                추가
            </button>

        </div>
    );
};

export default OneWriteForm;