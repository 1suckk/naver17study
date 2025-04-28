import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const ShopList = () => {
    const [shoplist, setShoplist] = useState([]);
    const navi = useNavigate(); //useNavigate를 사용하기 위해서 import 
    const photourl = process.env.REACT_APP_PHOTO_URL; //환경변수로 지정한 사진 URL

    //출력 함수

    //처음 로딩시 list 호출
    

    return (
        <div>
        
        </div>
    );
};

export default ShopList;