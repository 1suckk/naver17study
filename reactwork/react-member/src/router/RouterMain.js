import React from 'react';
import Menu from '../components/Menu';
import { Route, Routes } from 'react-router-dom';
import Home from '../components/Home';
import JoinForm from '../member/JoinForm';
import LoginForm from '../member/LoginForm';
import BoardList from '../board/BoardList';
import BoardForm from '../board/BoardForm';
import BoardDetail from '../board/BoardDetail';
import MemberList from '../member/MemberList';

const RouterMain = () => {
    return (
        <div>
            <Menu />
            <br style={{clear: 'both'}}/>
            <div style={{margin: '10px'}}>
                <Routes>
                    <Route path='/' element={<Home/>}/>
                    <Route path='/board/list' element={<BoardList/>}/>
                    {/* member 라우팅 부분 */}
                    <Route path='/member/join' element={<JoinForm/>}/>
                    <Route path='/member/list' element={<MemberList/>}/>
                    <Route path='/member/login' element={<LoginForm/>}/>
                    {/* board 라우팅 부분 */}
                    <Route path='/board/list' element={<BoardList/>}/>
                    <Route path='/board/form' element={<BoardForm/>}/>
                    <Route path='/board/detail/:num' element={<BoardDetail/>}/>
                    {/* 그 이외의 다름 매핑주소에서 호출 */}
                    <Route path='*' element={<Home/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default RouterMain;