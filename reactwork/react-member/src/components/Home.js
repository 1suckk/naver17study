import React from 'react';
import mainImage from '../image/mainImg.jpg';

const Home = () => {
    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                비트카센터 회원 사이트
            </h1>
            <img alt="" src={mainImage} style={{width:'90vw',border:'10px solid gold'}}/>
        </div>
    );
};

export default Home;