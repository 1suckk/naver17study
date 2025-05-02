import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // 페이지 이동을 위한 라이브러리 import
import axios from 'axios'; // axios 라이브러리 import

const LoginForm = () => {
    const [username, setUserName] = useState(''); // 상태 관리 (useState 훅 사용)
    const [password, setPassword] = useState(''); // 비밀번호 상태 관리
    const navi = useNavigate(); // 페이지 이동을 위한 useNavigate 훅 사용

    const onLoginSubmit = (e) => {
        e.preventDefault(); // 폼 제출 시 페이지 새로고침 방지
        
        // 로그인 요청 URL 설정
        let url = "/member/login?username=" + username + "&password=" + password;
        
        //db 저장후 로그인폼으로 이동
        axios.get(url)
        .then(res=>{
            if(res.data.token===null)
                alert('아이디 또는 비밀번호가 틀립니다!'); // 로그인 실패 알림
            else
            {
                sessionStorage.token = res.data.token; // 로그인 성공 시 토큰 저장
                navi('/board/list'); // 로그인 성공 시 게시판 페이지로 이동
            }
        }) // axios를 사용하여 서버에 POST 요청
    }

    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                로그인
            </h1>
            <form onSubmit={onLoginSubmit} style={{width:'70vw'}}>
                    <div className="mb-3">
                        <label htmlFor="username" className="form-label">아이디</label>
                        <input type="text" required className="form-control"
                        value={username}
                        onChange={(e)=>{setUserName(e.target.value)}}
                        placeholder="아이디를 입력하세요"/>
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">비밀번호</label>
                        <input type="password" value={password} 
                        className="form-control" 
                        onChange={(e)=>setPassword(e.target.value)} required
                        placeholder="비밀번호를 입력하세요"/>
                    </div>
                    <button type='submit' className='btn btn-success'>
                        로그인
                    </button>
            </form>

        </div>
    );
};

export default LoginForm;