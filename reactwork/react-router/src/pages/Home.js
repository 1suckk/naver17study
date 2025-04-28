import React from 'react';
import { Alert, Button } from '@mui/material';
import { NavLink, useNavigate } from 'react-router-dom';

const Home = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success'
            style={{fontSize:'20px'}}>Home 컴포넌트</Alert>
            <button className='btn btn-sm btn-primary'
            onClick={()=>navi("/food")}>
                조식 메뉴 확인
            </button>
            <button className='btn btn-sm btn-danger'
            onClick={()=>navi("/food/food1")}>
                중식 메뉴 확인
            </button>
            <button className='btn btn-sm btn-secondary'
            onClick={()=>navi("/food/food1/food2")}>
                석식 메뉴 확인
            </button>
        </div>
    );
};

export default Home;