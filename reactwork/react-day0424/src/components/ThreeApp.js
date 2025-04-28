import React from 'react';
import {Alert} from '@mui/material';
import posting from '../data/PostingData.json';
import './mystyle.css';

const ThreeApp = () => {
    const deal = posting.deal;

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
            임직원 할인 구매 쇼핑몰
            </Alert>
            <div className='maindiv'>
                <h5><b>오늘의 할인상품</b></h5>
                {
                    deal.map((item, i)=>
                    <div key={i} className='photodiv'>
                        <img alt='' src={item.img} className='photo'/>
                        <br/>
                        <div></div>
                        <div></div>
                    </div>)
                }
            </div> 
        </div>
    );
};

export default ThreeApp;