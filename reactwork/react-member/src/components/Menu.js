import React from 'react';
import {NavLink, useNavigate} from 'react-router-dom';
import './mystyle.css';

const Menu = () => {
    const navi = useNavigate(); // useNavigate 훅을 사용하여 페이지 이동 함수 생성

    return (
        <div>
            <ul className='menu' style={{width:'90vw',margin:'auto'}}>
                <li>
                    <NavLink to="/">Home</NavLink>
                </li>
                <li>
                    <NavLink to="/member/join">회원가입</NavLink>
                </li>
                <li>
                    <NavLink to="/board/list">게시판</NavLink>
                </li>
                <li>
                    <NavLink to="/member/list">회원목록</NavLink>
                </li>
                    {
                        sessionStorage.token==null?
                        <button type='button' className='btn btn-sm btn-primary'
                        onClick={() => {navi("/member/login")}}>로그인</button>
                        :
                        <button type='button' className='btn btn-sm btn-danger'
                        onClick={() => {
                            sessionStorage.removeItem('token');
                            window.location.reload();//token 삭제 후 새로고침
                        }}>로그아웃</button>
                    }
            </ul>
        </div>
    );
};

export default Menu;