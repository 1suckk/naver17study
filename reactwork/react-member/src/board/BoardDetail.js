import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const [selectData, setSelectData]=useState('');
    const {num}=useParams();
    const navi=useNavigate();
    const PHOTO_URL = process.env.REACT_APP_PHOTO_URL;

    return (
        <div>
            <h3 className='alert alert-danger'>게시판 상세보기</h3>
            {
                selectData &&
                <div>
                    <h2><b>{selectData.subject}</b></h2>
                    <span style={{color:'gray', marginLeft:'20px'}}>
                        {selectData.writeday}
                    </span>
                    <br/><br/>
                    <img alt='' src={PHOTO_URL+selectData.photo}
                    style={{maxWidth:'250px'}}/>
                </div>
            }
        </div>
    );
};

export default BoardDetail;