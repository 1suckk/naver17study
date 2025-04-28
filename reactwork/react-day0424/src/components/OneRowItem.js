import React from 'react';
import {DeleteForeverOutlined} from '@mui/icons-material';

const OneRowItem = (props) => {
    let {row, idx, onDelete} = props;
    return (
        <tr>
            <td>{idx+1}</td>
            <td>
                <img alt="" src={`../shop/${row.photo}`}
                style={{width:'30px', height:'30px', marginRight:'5px'}}/>
                {row.irum}
            </td>
            <td>직급: {row.rate}</td>
            <td>{row.Inyear}년도 입사</td>
            <td>
                <DeleteForeverOutlined
                style={{fontSize:'1.5em', color:'red', cursor:'pointer'}}
                onClick={()=>{
                    let alert = window.confirm('삭제할까요?');
                    if(!alert) return;

                    onDelete(idx);
                }}/>
            </td>
        </tr>
    );
};

export default OneRowItem;