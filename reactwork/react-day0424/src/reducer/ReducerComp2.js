import React, {useState, useReducer} from 'react';
import Student from './Student'; // Import the Student component

//reducer 설정 시 초기값으로 미리 지정
const initialState = {
    students: []
};

const reducer = (state, action) => {
    console.log(state, action);
    switch (action.type) {
        case 'addStudent':
            const name = action.payload.name;

            //추가할 학생정보
            const addStudent = {
                id: new Date(),
                name,
                isHere: false
            };

            return {
                count:state.count+1,
                students:[
                    ...state.students, //기존 학생정보
                    addStudent
                ]
            }

        case 'deleteStudent':
            return {
                count: state.count - 1, //인원수는 1만큼 줄이기
                students: state.students.filter(
                    //payload 를 통해서 삭제할 학생의 id를 받아서 해당 학생을 제외한 나머지 학생들만 남기기
                    s => s.id !== action.payload.id
                )
            }

        case 'markStudent': //이 액션이 발생하면 출석체크를 반전시킴
            return {
                count: state.count, //인원수는 그대로 유지
                students: state.student.map((student) =>
                    student.id === action.payload.id
                        ? { ...student, isHere: !student.isHere } //출석체크를 반전시킴
                        : student //그대로
                )
            }

        default:
            return state;
    }
};

const ReducerComp2 = () => {
    const [name, setName] = useState(''); //학생 이름을 입력받기 위한 state
    const [studentInfo, dispatch] = useReducer(reducer, initialState); //학생 정보를 관리하기 위한 state

    return (
        <div>
            <h5>useReducer 예제 #2</h5>
            <h2 className='alert alert-success'>학생 관리</h2>
            <div className='input-group' style={{width: '200px'}}>
                <input type='text' className='form-control'
                value={name} onChange={(e) => setName(e.target.value)} />
                &nbsp;&nbsp;
                <button type='button' className='btn btn-sm btn-primary'
                onClick={() => {
                    dispatch({ 'type': 'addStudent', payload: {name}});
                    setName(''); //입력창 초기화
                }}>추가
                </button>
                <br/>
                <br/>
                {
                    studentInfo.students.map((student, idx) => 
                        <Student key={idx} student={student}
                        dispatch={dispatch}/>
                    )
                }
            </div>
        </div>
    );
};

export default ReducerComp2;