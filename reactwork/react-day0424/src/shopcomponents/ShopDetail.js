import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import {Alert} from '@mui/material';
import noimage from '../image/noimage.jpg';

const ShopDetail = () => {
    const navi = useNavigate(); //useNavigate를 사용하기 위해서 import
 

    const[selectData, setSelectData] = useState('');

    const {num} = useParams();

    //사진출력할 url
    const photourl = process.env.REACT_APP_PHOTO_URL; //환경변수로 지정한 사진 URL

    //num에 해당하는 데이터 가져오기
    const getSelectData = () => {
        let getUrl = "/react/detail?num=" + num;
        axios.get(getUrl)
        .then(res=>setSelectData(res.data))
    }

    //처음 로딩시 함수호출
    useEffect(()=>getSelectData(),[]);

    //삭제 함수
    const deleteEvent = () => {
        let a = window.confirm("정말 삭제하시겠습니까?"); //삭제 확인 
        if(!a) return; 

        let deleteurl = "/react/shopdelete?num=" + num;
        axios.delete(deleteurl)
        .then(res=>navi("/five/list")); //삭제 성공 후 목록으로 이동
    }

    return (
        <div>
            <Alert severity='info'>상세정보</Alert>
            {
                selectData &&
                <div>
                    <h2><b>{selectData.sangpum}</b></h2>
                    <table>
                        <tbody>
                            <tr>
                                <td align='center' width='370'>
                                    <img alt='' src={selectData.photo?photourl+selectData.photo:noimage}
                                     style={{width:'300px',height:'400px',border:'1px solid gray',
                                        marginRight:'70px'}}/>
                                </td>
                                <td valign='middle'>
                                    <h3>상품명: {selectData.sangpum} </h3>
                                    <h3>색상: &nbsp;&nbsp; 
                                        <div style={{backgroundColor:selectData.color,width:'100px',
                                        display:'inline-block',height:'25px',
                                        border:'1px solid black'}}></div>
                                    </h3>
                                    <h3>가격: {selectData.price}원</h3>
                                    <h3>구입일 : {selectData.sangguip}</h3>
                                    <h4>등록일 : {selectData.writeday}</h4>
                                    <br/><br/>
                                    <button type='button' className='btn btn-sm btn-secondary'
                                    onClick={()=>navi('/five/form')}>상품추가</button>
                                    &nbsp;
                                    <button type='button' className='btn btn-sm btn-secondary'
                                    onClick={()=>navi('/five/list')}>상품목록</button>
                                    &nbsp;
                                    <button type='button' className='btn btn-sm btn-secondary'
                                    onClick={()=>navi(`/five/updateform/${num}`)}
                                    >상품수정</button>
                                    &nbsp;
                                    <button type='button' className='btn btn-sm btn-secondary'
                                    onClick={deleteEvent}>상품삭제</button>
                                    &nbsp;
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            }
        </div>
    );
};

export default ShopDetail;