import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'; 
import {DeleteForeverOutlined} from '@mui/icons-material';
import axios from 'axios';

const MemberList = () => {
    const [memberList, setMemberList] = useState([]);
    const [errorMsg, setErrorMsg] = useState(null);

    const navi = useNavigate();

    const getMemberData=()=>{
        axios({
            method:'get',
            url:'/auth/member/list',
            headers:{Authorization:`Bearer ${sessionStorage.token}`}
        }).then(res=>{
            setMemberList(res.data);
        }).catch(error=>{
            //alert(error); 
            setErrorMsg("403"); //403 에러가 뜨면 즉, 일반 회원이 열람 시도시
        });
    }

    //처음부터 로딩
    useEffect(()=>{
        getMemberData();
    },[]);

    //삭제 이벤트
    const deleteMember=(id)=>{
        let a=window.confirm("해당 멤버를 삭제할까요?");
        if(!a) return;

        axios.delete("/auth/member/delete?id="+id)
        .then(res=>getMemberData());
    }

    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                회원 목록
            </h1>
            {
               sessionStorage.token==null?
                 <div>
                     <h1>먼저 로그인을 해주세요</h1>
                 </div>
             :
             errorMsg==='403'?
             <div>
                 <h1>관리자만 볼수 있는 페이지입니다</h1>
             </div>
             : 
                <table className='table table-bordered' style={{width:'800px'}}>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>주소</th>
                        <th>권한</th>
                        <th>가입일</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    //로그인이 안되어 있으면 로그인을 하도록, 403에러가 뜬다면 
                    //관리자에게 문의하도록 화면에 사용자로 하여금 주지시킬 것
                    memberList && memberList.map((row, idx) => 
                    <>
                        <tr key={idx}>
                            <td align='left'>
                                {row.id}
                            </td>
                            <td align='center'>
                                {row.username}
                            </td>
                            <td>
                               {row.address} 
                            </td>
                            <td>
                                {row.role==='ROLE_ADMIN'?'관리자':'회원'}
                            </td>
                            <td>
                                {row.gaipday}
                            </td>
                            <td>
                                <DeleteForeverOutlined
                                style={{fontSize:'1.5em', color:'red', cursor:'pointer'}}
                                onClick={()=>{
                                    deleteMember(row.id);
                                }}/>
                            </td>
                        </tr>
                    </>)
                }
                </tbody>
            </table>
            }
        </div>
    );
};

export default MemberList;