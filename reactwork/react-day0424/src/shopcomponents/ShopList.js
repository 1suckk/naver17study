import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import noimage from '../image/noimage.jpg';

const ShopList = () => {
    const [shoplist, setShoplist] = useState([]);
    const navi = useNavigate(); //useNavigate를 사용하기 위해서 import 
    const photourl = process.env.REACT_APP_PHOTO_URL; //환경변수로 지정한 사진 URL

    //출력 함수
    const list=()=>{
        axios.get("/react/shoplist")
        .then(res=>setShoplist(res.data));
    }

    //처음 로딩시 list 호출
    useEffect(() => {
        list();
    }, []); 

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
                상품 데이터 조회    
            </Alert>
            <table className='table table-bordered' style={{width:'700px'}}>
                <thead>
                    <tr>
                        <th>상품명</th>
                        <th>색상</th>
                        <th>가격</th>
                        <th>구입일</th>
                        <th>등록일</th>
                    </tr>
                </thead>
                <tbody>
                {
                    shoplist && shoplist.map((row, idx) => 
                        <tr key={idx}>
                            <td align='center'>
                                <img alt='' src={row.photo?photourl+row.photo:noimage}
                                style={{width:'30px',height:'30px',border:'1px solid gray'}}
                                />
                                &nbsp;
                                {row.sangpum}
                            </td>
                            <td>
                            {row.color}
                            </td>
                            <td>
                                {row.price}원
                            </td>
                            <td align='right'>
                                {row.sangguip}
                            </td>
                            <td align='center'>
                                <button className='btn btn-primary'
                                onClick={()=>navi(`/five/detail/${row.num}`)}>  
                                상세보기</button>
                            </td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default ShopList;