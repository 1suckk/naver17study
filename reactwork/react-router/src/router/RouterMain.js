import React from 'react';
import Menu from '../components/Menu';
import { Route, Routes } from 'react-router-dom';
import {About, Food, Home} from '../pages';

const RouterMain = () => {
    return (
        <div>
            <Menu />
            <hr style={{clear: 'both'}}/>
            <Routes>
                <Route path='/' element={<Home />} />
                <Route path='/about' element={<About />}> 
                    <Route path='/about/:emp' element={<About />} />
                </Route>
                <Route path='/food' element={<Food />}>
                    <Route path=':food1' element={<Food />} />
                    <Route path=':food1/:food2' element={<Food />} />
                </Route>
                <Route path='/login' element={
                    <div>
                        <h2>로그인 페이지는 작업중입니다.</h2>
                    </div>
                }/>

                {/* 그 이외의 모든 매핑주소일 경우 호출 */}
                <Route path='*' element={
                    <div>
                        <h2>잘못된 주소입니다.</h2>
                        <h3>주소를 확인하세요.</h3>
                    </div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;