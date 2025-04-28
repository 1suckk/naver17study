import * as React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  variants: [
    {
      props: ({ expand }) => !expand,
      style: {
        transform: 'rotate(0deg)',
      },
    },
    {
      props: ({ expand }) => !!expand,
      style: {
        transform: 'rotate(180deg)',
      },
    },
  ],
}));

export default function RecipeReviewCard() {
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <div>
      <h3 className='alert alert-success'>고객 리뷰</h3>
      <div style={{display:'flex', flexWrap:'wrap', gap:'24px', justifyContent:'center'}}>
      <Card sx={{ maxWidth: 345, marginLeft: '100px'}}>
        <CardHeader
          avatar={
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              R
            </Avatar>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          title="레이 차 인도받았는데 깔끔^^"
          subheader="April 14, 2025"
        />
        <CardMedia
          component="img"
          height="194"
          image="./01_ray.png"
          alt=""
        />
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            비트카센터의 전기차 너무 좋아여
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites">
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography sx={{ marginBottom: 2 }}>
              비트카센타 갔는데 상담도 너무 잘해주시고 차도 깔끔해요~~
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
              가능한 차량은 기아의 RAY EV 차량입니다.
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
              전기차의 경우 보조금 지원을 최대한 많이 받으실 수 있도록 해주시는데 덕분에 돈 굳었스요^^
            </Typography>         
          </CardContent>
        </Collapse>
      </Card>
      <Card sx={{ maxWidth: 345, marginLeft: '100px'}}>
        <CardHeader
          avatar={
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              S
            </Avatar>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          title="법인차로 안심이 되네요^^"
          subheader="April 17, 2025"
        />
        <CardMedia
          component="img"
          height="194"
          image="./01_ray.png"
          alt=""
        />
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            일 때문에 법인차량을 뽑았는데 승차감 안정성 굳~~
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites">
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography sx={{ marginBottom: 2 }}>
              비트카센타 갔는데 상담도 너무 잘해주시고 차도 깔끔해요~~
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
              가능한 차량은 기아의 RAY EV 차량입니다.
            </Typography>
            <Typography sx={{ marginBottom: 2 }}>
              전기차의 경우 보조금 지원을 최대한 많이 받으실 수 있도록 해주시는데 덕분에 돈 굳었스요^^
            </Typography>         
          </CardContent>
        </Collapse>
      </Card>
      </div>
    </div>
  );
}