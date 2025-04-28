import React from 'react';
import {Alert} from '@mui/material';
import { Route, Routes, useNavigate } from 'react-router-dom';
import {ShopList, ShopForm, ShopDetail} from '../shopcomponents';

const FiveApp = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success'
            style={{fontSize:'25px'}}>5번 페이지</Alert>
            <div style={{margin:'20px'}}>   
                <button className='btn btn-sm btn-primary'
                onClick={()=>navi("/five/list")}>shop 목록</button>
                &nbsp;&nbsp;
                <button className='btn btn-sm btn-primary'
                onClick={()=>navi("/five/form")}>shop 추가</button>
                <br/><br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='/list' element={<ShopList/>}/>
                    <Route path='/form' element={<ShopForm/>}/>
                    <Route path='/detail/:num' element={<ShopDetail/>}/>    
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;