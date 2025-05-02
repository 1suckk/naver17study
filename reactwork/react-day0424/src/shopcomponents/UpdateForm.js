import React, { useEffect, useState } from 'react';
import { Alert } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const UpdateForm = () => {
    const [shopData, setShopData] = useState(''); //상품 수정에 필요한 데이터
    const [photo, setPhoto] = useState(null); //업로드한 사진을 저장하기 위한 변수
    const [num, setNum] = useState(''); //수정할 상품의 번호

    const navi = useNavigate(); //useNavigate를 사용하기 위해서 import

    //처음 시작 시 스프링으로부터 데이터 가져오기
    const getSelectedData = () => {
        let url="/react/detail?num="+num;
        axios.get(url)
        .then(res=>{
            setShopData(res.data);
            setPhoto(res.data.photo); //기존 사진을 보여주기 위해서
        });
    }

    useEffect(()=>{
        getSelectedData();
    },[]); //처음 시작 시에 한번만 실행 

    //입력시 호출
    const shopDataChange=(e) => {
        const {name, value} = e.target; //name과 value를 분리
        setShopData({
            ...shopData,
            [name]: value
        });
    }

    //submit 발생시 호출하는 함수
    const onSubmit=(e) => {
        e.preventDefault(); //submit이 발생하면 페이지가 새로고침 되는 것을 방지
        
        //수정
        axios.post("/react/shopupdate", shopData)
        .then(res=>{
                navi(`/five/detail?num=${num}`);
        });
    }

    return (
        <div>
            <Alert severity="info" style={{margin:'500px'}}>
                상품 수정
            </Alert>
            <form onSubmit={onSubmit}>
            <table className='table table-bordered'>
                <tbody>
                    <tr>
                        <td align='center'>
                            상품명
                            <input type='text' name='sangpum' value={shopData.sangpum}
                            onChange={shopDataChange}/>
                        </td>
                    </tr>
                </tbody>
            </table>
            </form> 
        </div>
    );
};

export default UpdateForm;