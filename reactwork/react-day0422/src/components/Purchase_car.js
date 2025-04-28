import React, { useState } from 'react';
import './mystyle.css';
import ray from './01_ray.png';
import b2b from './b2b_sample.jpg';
import offload from './offload_sample.jpg';

//스타일 적용하는 방법 : 변수로 지정하는 방법
const OneApp = () => {
    const ev_wrapper = {
        color: 'green',
        width: '400px'
    }

    const [img, setimg] = useState(ray);
    const [imgWidth, setImgWidth] = useState(1000);
    const [carImgCheck, setCarImgCheck] = useState(false);

    const CarCheckHide=(e)=>{
        setCarImgCheck(e.target.checked);
    }

    const resizeCarImage = (change) => {
        setImgWidth(prevImgWidth => {
            const newImgWidth = prevImgWidth + change;
            return newImgWidth > 0 ? newImgWidth : prevImgWidth; //0보다 작아지지 않게
        })
    }

    return (
        <div>
            {/* {}내부에 넣어줘야 한다 */}
            <h3 className='alert alert-secondary'>차량구매</h3>
            <label>
                <input type='checkbox' onClick={CarCheckHide}/> 사진 숨기기
            </label>
            &nbsp;&nbsp;
            <button className='btn btn-success' id="carSizeDownBtn"
            onClick={() => resizeCarImage(-20)}>사이즈 감소</button>
            &nbsp;&nbsp;
            <button className='btn btn-info' id="carSizeUpBtn"
            onClick={() => resizeCarImage(20)}>사이즈 증가</button>
            <h5 style={ev_wrapper} onClick={() => setimg(ray)}>
                전기차 구매
            </h5>
            <h5 style={{color:'blue',fontFamily:'Jua'}}
            onClick={() => setimg(b2b)}>
                법인차 리스
            </h5>
            <h5 className='offload_wrapper' 
            onClick={() => setimg(offload)}>
                오프로드 구매
            </h5>
            {
            !carImgCheck&&
            <img alt='' src={img} style={{width:`${imgWidth}px`}}/>
            }
        </div>
    );
};

export default OneApp;