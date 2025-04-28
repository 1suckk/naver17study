import React, {useState, useReducer} from 'react';
/*
useReducer: state 관리가 용이하며 유지, 보수가 편리하다 
호출: dispatch(type, action)-->reducer(state, action)
type은 문자로 줘도 되지만 오타가 날 가능성이 다분함

기능
reducer: state를 변경하는 함수
dispatch: action을 reducer에 전달하는 함수
action: state를 변경하는 정보
*/

//action type을 미리 상수화해서 정해놓고 사용하면 오타를 줄일 수 있다.
const ACTION_TYPES={
    add:'addmoney',
    sub:'submoney'
}

//reducer 함수: state를 변경하는 함수
const reducer=(state, action) => {
    console.log('reducer', state, action);
    
    switch(action.type){
        case ACTION_TYPES.add:
            return {money: state.money + action.payload};
        case ACTION_TYPES.sub:
            return {money: state.money - action.payload};
        default:
            return state;
    }
}

const ReducerComp1 = () => {
    const [number, setNumber] = useState(0);
    const [money, dispatch] = useReducer(reducer, 0); //money는 state, dispatch는 action을 reducer에 전달하는 함수
    
    return (
        <div>
            <h5>useReducer 예제 #1</h5>
            <h2 className='alert alert-success'>은행 메인화면</h2>
            <h3>현재 잔고: {money}원</h3>
            <input type='number' value={number}
            step={1000} onChange={(e)=>setNumber(e.target.value)}/>
            &nbsp;
            <button type='button' className='btn btn-primary'
            onClick={()=>dispatch({type: ACTION_TYPES.add, payload: parseInt(number)})}>
                입금
            </button>
            &nbsp;
            <button type='button' className='btn btn-danger'
            onClick={()=>dispatch({type: ACTION_TYPES.sub, payload: parseInt(number)})}>
                출금
            </button>
        </div>
    );
};

export default ReducerComp1;