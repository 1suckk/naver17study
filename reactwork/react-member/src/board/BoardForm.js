import React from 'react';

const BoardForm = () => {
    const onSaveSubmit=(e)=>{
        e.preventDefault();
    }

    return (
        <div>
            <h3>회원 글쓰기</h3>
            <form onSubmit={onSaveSubmit}>
                <table className='table table-bordered'>
                    <thead>

                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>
            </form>
        </div>
    );
};

export default BoardForm;