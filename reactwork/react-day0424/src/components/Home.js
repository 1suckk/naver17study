import React from 'react';
import mainImage from '../image/mainImg.jpg';

const Home = () => {
    return (
        <div>
            <h1 className='alert alert-danger'>
                Router Axios Study!!!!
            </h1>
            <img alt="" src={mainImage}
            style={{width:'300px',border:'10px solid gold',
                margin:'30px'
            }}/>
        </div>
    );
};

export default Home;