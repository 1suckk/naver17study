import React, { useState } from 'react';

const EightApp = () => {
    const regions = [{name:'서울'},{name:'경기'},{name:'부산'}];
    
    const [carShopRegion, setCarShopRegion] = useState('서울');

    const selectRegion = (e) => {
        setCarShopRegion(e.target.value);
    };

    return (
        <div>
            <h3 className='alert alert-success'>지점 검색하기</h3>
            <select style={{width:'200px'}} value={carShopRegion}
            onChange={selectRegion}>
                {regions.map((region) => (
                   <option key={region.name} value={region.value}>
                        {region.name}
                   </option>
                ))}
            </select>
            {carShopRegion === '서울' && (
            <div style={{display:'flex', flexWrap:'wrap', gap:'8px'}}>
                {
                    [...new Array(3)].map((_,idx)=>
                        <img alt='' key={idx} src={require(`./shop_region/${idx+1}.jpg`)}    
                        style={{width:'500px'}}/>
                    )
                }
            </div>
            )}

            {carShopRegion === '경기' && (
            <div style={{display:'flex', flexWrap:'wrap', gap:'8px'}}>
                {
                    [...new Array(3)].map((_,idx)=>
                        <img alt='' key={idx} src={require(`./shop_region/${idx+4}.jpg`)}    
                        style={{width:'500px'}}/>
                    )
                }
            </div>
            )}

            {carShopRegion === '부산' && (
                <div style={{display:'flex', flexWrap:'wrap', gap:'8px'}}>
                {
                    [...new Array(1)].map((_,idx)=>
                        <img alt='' key={idx} src={require(`./shop_region/${idx+7}.jpg`)}    
                        style={{width:'500px'}}/>
                    )
                }
            </div>
            )}
        </div>
    );
};

export default EightApp;