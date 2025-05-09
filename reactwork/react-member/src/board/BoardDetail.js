import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const [selectData, setSelectData]=useState('');
    const [error, setError]=useState('');

    const {num}=useParams();
    const navi=useNavigate();
    const PHOTO_URL = process.env.REACT_APP_PHOTO_URL;

    const getSelectData=()=>{
        axios({
            method:'get',
            url:'/auth/board/detail?num='+num,
            headers: {Authorization:`Bearer ${sessionStorage.token}`}
        }).then(res=>{
            setSelectData(res.data);
        }).catch(error=>setError("403"));
    }

    //시작할 때 바로 데이터가 나오도록
    useEffect(()=>{
        getSelectData();
    },[]); 

    return (
        <div>
            <h3 className='alert alert-danger'>게시판 상세보기</h3>
            {
                selectData &&
                <div>
                    <h2><b>{selectData.subject}</b></h2>
                    <span style={{color:'gray'}}>
                        작성자: {selectData.username} &nbsp;&nbsp;
                    </span>

                    <span style={{color:'gray'}}>
                        작성일자: {selectData.writeday}
                    </span>
                    <br/><br/>
                    <img alt='' src={PHOTO_URL+selectData.photo}
                    style={{maxWidth:'250px'}}/>
                    <br/><br/>
                    <pre style={{fontSize:'20px'}}>{selectData.content}</pre>
                    <br/><br/>
                    <button type='button' className='btn btn-sm btn-secondary'
                    style={{width:'100px'}}
                    onClick={()=>navi('/board/form')}>글쓰기</button>
                    &nbsp;
                    <button type='button' className='btn btn-sm btn-success'
                    style={{width:'100px'}}
                    onClick={()=>navi('/board/list')}>글목록</button>
                    {
                        selectData.username===sessionStorage.getItem('username')
                        ?
                        <>
                            &nbsp;
                            <button type='button' className='btn btn-sm btn-info'
                            style={{width:'100px'}}
                            onClick={()=>navi(`/board/updateform/${num}`)}>
                                글수정
                            </button>
                        </>
                        :
                        <></>
                    }
                </div>
            }
        </div>
    );
};

export default BoardDetail;