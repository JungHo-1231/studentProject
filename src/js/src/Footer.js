import { Button, Avatar } from 'antd';
import React from 'react';
import Container from './Container';
import './Footer.css';

const Footer = (props) => {
	return (
		<di className="footer">
			<Container>
				{props.numberOfStudents !== undefined ? (
					<Avatar
						style={{
							backgroundColor : '#f56a00',
							marginRight     : '5px'
						}}
						size="large"
					>
						{props.numberOfStudents}
					</Avatar>
				) : null}
				<Button
					onClick={() => {
						props.handleAddStudentClickEvent();
					}}
					type="primary"
				>
					Add new student +
				</Button>
			</Container>
		</di>
	);
};

export default Footer;
