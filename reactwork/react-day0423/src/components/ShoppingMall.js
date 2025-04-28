import {Alert} from '@mui/material';
import React, { useState } from 'react';

const MENU_COUNT = 3; //메뉴 사진 갯수

const ShoppingMall = () => {
    //주문내역: {idx: 메뉴번호, count: 주문 갯수}
    const [orders, setOrders] = useState([]);
    //초기 주문이 아예 없을시 보이는 문구
    const showGuide = orders.length === 0;
    //메뉴 배열
    const menuList = [
        { name: "아메리카노", price: 1500, img: "/menupic/1.jpg" },
        { name: "카페라떼", price: 3500, img: "/menupic/2.jpg" },
        { name: "아샷추", price: 4000, img: "/menupic/3.jpg" }
      ];

    //주문 추가 함수
    const handleIncrease = (idx) => {
        setOrders(prev=>{
            const found = prev.find(item=>item.idx===idx);
            if (found)
            {
                return prev.map(item=>
                    item.idx === idx ? {...item, count: item.count + 1} : item
                );
            }
            else
            {
                return [...prev, {idx,count:1}];
            }
        });
    };

     // 주문 감소 함수
    const handleDecrease = (idx) => {
        setOrders(prev => {
            const found = prev.find(item => item.idx === idx);
            if (!found) return prev;
            if (found.count === 1) {
                // 1개일 때 감소하면 목록에서 제거 (filter 사용)
                return prev.filter(item => item.idx !== idx);
            }
            else {
                // 2개 이상이면 count만 감소
                return prev.map(item =>
                    item.idx === idx ? { ...item, count: item.count - 1 } : item
                );
            }
        });
    };

    //총 가격 함수
    const totalPrice = orders.reduce(
        (sum, order) => sum + menuList[order.idx].price * order.count, 0
    );

    return (
        <div>
            <Alert severity='success'>쇼핑몰</Alert>

            <div style={{display:'flex',flexWrap:'wrap',gap:'8px'}}>
                {menuList.map((menu, idx)=>
                    <div key={idx} style={{textAlign:'center'}}>
                        <img key={idx}
                        alt=''
                        src={`/menupic/${idx+1}.jpg`}
                        style={{height:'300px'}}/><br/>
                        <button onClick={() => handleIncrease(idx)}>
                        +</button>
                        <button onClick={() => handleDecrease(idx)}>
                        -</button>
                    </div>
                )}
            </div>
            <hr/>
            <div style={{width:'1200px', margin:'30px 30px'}} className='alert alert-danger'>
                <h4>주문하신 메뉴</h4>
                {showGuide?(
                    <Alert severity='info' style={{fontWeight:'bold'}}>
                        메뉴를 주문하면 추가가 됩니다.
                    </Alert>
                ):(
                    <div style={{display:'flex',gap:'16px',flexWrap:'wrap'}}>
                        {orders.map(order => 
                        <div>
                            <img
                            alt={menuList[order.idx].name}
                            src={menuList[order.idx].img}
                            style={{width:'120px'}}/><br/>
                            <span>메뉴: {menuList[order.idx].name}</span><br/>
                            <span>수량: {order.count}개</span><br/>
                            <span>가격: {menuList[order.idx].price * order.count}</span>
                            <button onClick={()=>handleDecrease(order.idx)}>-</button>
                        </div>
                        )}
                    </div>
                )}
                <div style={{marginTop:'20px', fontSize:'18px'}}>
                    총 계산금액: <b>{totalPrice.toLocaleString()}</b> 원<br/>
                    <button>카드결제</button>
                </div>
            </div>
        </div>
    );
};

export default ShoppingMall;