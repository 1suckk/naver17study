import React, {useRef} from 'react';
import {Alert} from '@mui/material';
import cate from '../data/CateData.json';
import posting from '../data/PostingData.json';
import './mystyle.css';

const TwoApp = () => {
    const navData = cate.navData;
    const CateData = cate.categoryData;
    const mainPhotoRef = useRef(null);

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
            오늘의집 category json 출력
            </Alert>
            <div className='nav_category'>
                <ul className='nav_category'>
                {
                    navData.map((item,i)=>
                        <li key={i}>
                            <div>
                                <img alt='' src={item.img}
                                className='imgcategory'
                                onClick=
                                {(e)=>mainPhotoRef.current.src=e.target.src}/>
                            </div>
                        </li>
                    )
                }
                </ul>
            </div>

            <div className='nav_container'>
                <ul className='nav_category'>
                {
                CateData.map((item, i)=>
                    <li key={i}>
                        <div>
                            <img alt='' src={item.img}
                            className='imgcategory'
                            onClick=
                            {(e)=>mainPhotoRef.current.src=e.target.src}/>
                        </div>
                    </li>)
                }
                </ul>
            </div>

            {/* 아이콘 클릭시 작은 이미지를 가져와서 출력할 이미지 */}
            <div>
                <img alt='' src=''
                style={{width:'300px', height:'300px',
                border:'5px inset gray', margin:'10px 300px'}}
                ref={mainPhotoRef}/>    
            </div> 
        </div>
    );
};

export default TwoApp;