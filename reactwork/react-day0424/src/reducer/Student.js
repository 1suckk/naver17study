import React from 'react';

const Student = (props) => {
    const { student, dispatch } = props; //props로 전달된 student와 dispatch를 구조분해 할당
    return (
        <div className='input-group' style={{ width: '300px', margin: '5px 20px' }}>
            <div style={{textDecoration: student.isHere ? 'line-through' : 'none',
            width: '100px', cursor: 'pointer',
            color: student.isHere ? 'gray' : 'black'
            }} onClick={() => dispatch({type: 'markStudent', payload: { id: student.id }})}>
                {student.name}
            </div>
            &nbsp;&nbsp;
            <button type='button' className='btn btn-sm btn-danger'
            onClick={() => dispatch({ type: 'deleteStudent', payload: { id: student.id } })}>
                삭제
            </button>
        </div>
    );
};

export default Student;