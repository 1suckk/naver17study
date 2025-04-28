import {Alert} from '@mui/material';
import React, { useState } from 'react';


//회사에 대한 문의사항
//배열 추가 삭제 가능하도록
//concat으로 추가
const Qna = () => {

    const [msg, setMsg] = useState(['회사와 관련된 내용은 여기에 문의 주세요',
    '관리자: 채원석 주임', '매일 12시에 확인']);

    //메시지 입력 후 엔터 누르면 배열에 추가하는 함수
    const addMessageEvent=(e)=>{
        if(e.key==='Enter')
        {
            //push 대신 concat 
            setMsg(msg.concat(e.target.value));
            e.target.value="";
        }
    }

    //삭제하는 함수
    const deleteMessage=(i)=>{
        setMsg(msg.filter((m, idx)=>idx!==i));
    }

    return (
        <div style={{width:'400px', margin:'0 30px'}}>
            <Alert severity='success'>관리자와 문의사항</Alert>
            <h6>추가할 문의를 적어주세요</h6>
            <input type='text' className='form-control'
            placeholder='문의 메시지' autoFocus
            onKeyUp={addMessageEvent}/><br/>
            <h6 style={{backgroundColor:'orange'}}>문의사항 총 {msg.length}개</h6>
            {
            msg.map((m, i) =>
                <h5 key={i}>
                    {i+1}:{m}
                    <i class="bi bi-trash-fill"
                    style={{float:'right', cursor:'pointer',color:'red'}}
                    onClick={()=>deleteMessage(i)}></i>
                </h5>)
            }
        </div>
    );
};

export default Qna;