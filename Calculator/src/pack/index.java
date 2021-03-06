package pack;
import java.awt.*;
/*	�����������: 
javax.* � ����������� ����������.(����������� ���������� (standard extensions) � ��� ������ ��� ������ ������� Java)
Swing - ���������� ������������ ���������� (���������� �����), � ������� �� java.awt, javax.swing ����� ����� ������ 
������� ���������� � ����� ������� ����� �������
"*"-��������� ���� ��������� ���������� Swing (jbutton,jpanel,jlabel � �.�.)
"."(�����) ������������ ��� ��������� ��������� �� ������ �� ������.
*/
import javax.swing.*;
import javax.swing.border.*;//���������� ����������� ��� ����, ����� ���������� �������
import java.awt.event.*;
/*	java. - ��� ����������� ������, ������������ � �������� Java, �������� � ������ java.
java.awt  - ����������� ������ awt, ����������� ������� ����������� �������:GridLayout, BorderLayout � �.�.
"*"-��������� ���� ��������� ���������� awt */	


public class index extends JFrame{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static index frame = new index(); 
	
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
	
					frame.setVisible(true); //������������� ��� ���� Index (������ ������� �������) ����� ������������

				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}
	
	
	private JPanel panel, panel1;//������ �� ������� ������������� ���� � ������. ������ �������� ������ ��� ������� ������ (private)
	private JButton calc;// ������ ���������� ������� �������� ������ ��� ������� ������
	private JLabel label_1,label_2,label_3, label_4,label_n,sum_n,sum;// ��������� �� ������� ������������� �����
	public static JTextField sum_ok;
	/* ��������� ���� � ������� ������������ ������ ������, �������� ��� ������ ����� �� ������ pack */
	public static JRadioButton rad_13, rad_15, rad_30, rad_35;/* ��������� ������������� (��� ������� �� ���� �� 
	����� ������ ����� ������� ������ ������������ � �������� ���������)*/
	public static int int_rad=13;
	
	public index() { 
		setTitle("����������� ����"); //������������� �������� ���� 
		setSize(320, 240); // ��������� ������ � ������.
		setLocationRelativeTo(null);//���������� ���������� ������
		
		//�� �������� ����� - ��������� ����������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout (new BorderLayout()); 

        panel = new JPanel();//������ �� �������  ������������� ��������� ���� � ���� ��� ����� ������
		panel1 = new JPanel();//������ �� ������� ������������� ������

		add(panel, BorderLayout.CENTER);//���������� ������ panel �� ������
		add(panel1, BorderLayout.SOUTH);//���������� ������ panel1 �����

		panel.setBorder(new EmptyBorder(10,10,10,10));//��������� ���������� ��������
		panel1.setBorder(new EmptyBorder(10,10,10,10));//��������� ���������� ��������
	
		/* ��������� ��������� ���������� GridLayout. ������ �������� ���������� ����������� ���������� � 
		 * ������� */
		panel.setLayout(new GridLayout(6,2,15,0));/* �� ������ 6 �����,2�������,15 - ���������� ����� ���������,  0- ����� ��������  */
		panel1.setLayout(new GridLayout(1,1));//�� ������ 1 ������,1�������, ����� ����������� ������

		label_1 = new JLabel("����� ������, ���.", JLabel.LEFT);
		label_2 = new JLabel("��������� ������", JLabel.LEFT);
		label_3 = new JLabel("����� ������, ���.", JLabel.LEFT);
		label_4 = new JLabel("����� �� ����, ���.", JLabel.LEFT);
		label_n = new JLabel("");
		sum_n = new JLabel("", JLabel.CENTER);
		sum = new JLabel("", JLabel.CENTER);
		/*���������� ��� ���������� Label_1,Label_2..�������� �������� JLabel � ��������� ����� ����� ����� ����������.
		JLabel.LEFT - ������������ �� ������ ����,
		JLabel.CENTER - ������������ �� ������
		*/
		
		calc = new JButton("����������"); //� ������� - ������� �� ������
	
		sum_ok = new JTextField();
		//������������ ������ �� ������
		sum_ok.setHorizontalAlignment(JTextField.CENTER); 
		sum_ok.setMargin(new Insets(2, 5, 2, 5));//��������� ���������� �������� ��� ���������� ���� (2-������� ������, 5-�����, 2-������, 5-������)

		ButtonGroup group = new ButtonGroup();
		rad_13 = new JRadioButton("13%",true);
		group.add(rad_13);
		rad_13.setHorizontalAlignment(JRadioButton.CENTER);
		rad_15 = new JRadioButton("15%", false);
		group.add(rad_15);
		rad_15.setHorizontalAlignment(JRadioButton.CENTER);
		rad_30 = new JRadioButton("30%", false);
		group.add(rad_30);
		rad_30.setHorizontalAlignment(JRadioButton.CENTER);
		rad_35 = new JRadioButton("35%", false);
		group.add(rad_35);
		rad_35.setHorizontalAlignment(JRadioButton.CENTER);

		//���������� ����������� JRadioButton, JLabel, JTextField �� ������ panel
		panel.add(label_1);
		panel.add(sum_ok);
		panel.add(label_2);
		panel.add(label_n);
		panel.add(rad_13);
		panel.add(rad_15);
		panel.add(rad_30);
		panel.add(rad_35);
		panel.add(label_3);
		panel.add(sum_n);
		panel.add(label_4);
		panel.add(sum);
		panel1.add(calc);//���������� ������ �� ������ panel1
		//���������� ����������� JLabel, JTextField �� ������ panel,panel1,panel2

		rad_13.addActionListener(new ActionListener()
        {
			/* 	rad_13 - ��������� �������������
	 		"."  - ��������� � ����� ���������� ������� ��������� ���������.
	 		addActionListener - ���������� ��������� ActionListener � �������������
	  		new - �������� new ������� ��������� ���������� ������ 
	  		(��� ���� ����� ������ ����� ���������������, ������ �� ��� ���������� ��������� ���������� �������, 
	  		������� ����� �������� �� ������������ �� �������. 
	  		� ����� ������ ��������� ���������������� ������� ������� �� ������������� � ����� ������ �����. 
	  		������� ����� �������������� ��������� "ActionListener", 
	  		��������������� ��� ��������� ������� "ActionEvent".
	  		���� ���������� ����������� ���� ����� �������� ������ "{"
	  		*/ 
			 public void actionPerformed(ActionEvent e)
	            {
	            	
	                int_rad=13; 
	    			sum_n.setText("");//�������� ��������� ����
	    			sum.setText("");
	            }
	        });
			rad_15.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=15; 
	    			sum_n.setText("");//�������� ��������� ����
	    			sum.setText("");
	            }
	        });
			rad_30.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=30; 
	    			sum_n.setText("");//�������� ��������� ����
	    			sum.setText("");
	            }
	        });
			rad_35.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=35; 
	    			sum_n.setText("");//�������� ��������� ����
	    			sum.setText("");
	            }
	        });
			
			calc.addActionListener(new ActionListener()   
	    			
	    	   {                                                         
	    	    public void actionPerformed(ActionEvent e)   
	    	   
	    	    {  
		    		
	    	    	if (isValidInput(sum_ok, "����� ������")) {
		    		
	    	    		double d_sum_ok= Double.parseDouble(sum_ok.getText().replace(',','.'));
	    	    	
	    	    		double d_sum_n = d_sum_ok/100*int_rad;//������ ����� ������
	    	    		double d_sum = d_sum_ok-d_sum_n;//������ ����� �� ����

	    	    		String s_sum_n = String.format("%.2f", d_sum_n);
	    	    		    
	    	    		sum_n.setText(s_sum_n); /* ���������� ��������� ���������� � ���� Jlabel */
	    	    		String s_sum = String.format("%.2f", d_sum);
	    	    		sum.setText(s_sum); /* ���������� ��������� ���������� � ���� Jlabel */ 	    		
	    	    	}
	    	    	}   	    	                             
	    	   }); 
		}	
	//�������� ������, ��������� �������������
    public static boolean isValidInput(JTextField jtxt, String description) {

        JDialog D = new JDialog();
		//���� ��� ������ �����-���� �����
        if (jtxt.getText().trim().length() > 0) {
            //�������� �� ���� ������ ������ �����
            try { 
              
                 double num = Double.parseDouble(jtxt.getText().replace(',','.')); //������� ������������� ����� � ����� �����      
                return true; //���� ��� ��������� - ���������� true

            } catch (NumberFormatException e) {
            	

                //����������� ������ � ��������� ����, ����� ������������ ��� ��� ���� �����
                jtxt.requestFocus();
                jtxt.setText("");//�������� ��������� ����
   			
                //�������������� - �������� ������ �����
                JOptionPane.showMessageDialog(D, "�� ������ ������ �����!", "������", JOptionPane.WARNING_MESSAGE);

                return false;//������ - ���������� false
            }

        } else {// ���� ������������ �� ����� ������� ������

            //��������������, ��� ����� ������ ������
            JOptionPane.showMessageDialog(D, "������� " + description, "������", JOptionPane.WARNING_MESSAGE);

            //����������� ������ � �������� ����, ����� ������������ ��� ��� ���� �����
            jtxt.requestFocus();
            jtxt.selectAll();//�������� ��������� ����

            //������ - ���������� false
            return false;
        }
    }	

}