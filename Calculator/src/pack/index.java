package pack;
import java.awt.*;
/*	Импортируем: 
javax.* — стандартные расширения.(Стандартные расширения (standard extensions) — это пакеты или наборы пакетов Java)
Swing - Библиотека графического интерфейса (конкретный пакет), В отличие от java.awt, javax.swing имеет более гибкую 
систему управления и более широкий набор функций
"*"-включение всех элементов библиотеки Swing (jbutton,jpanel,jlabel и т.д.)
"."(точка) используется для выделения элементов из ссылки на объект.
*/
import javax.swing.*;
import javax.swing.border.*;//библиотека необходимая для того, чтобы установить отступы
import java.awt.event.*;
/*	java. - Все стандартные классы, поставляемые с системой Java, хранятся в пакете java.
java.awt  - подключение пакета awt, содержащего базовые графические функции:GridLayout, BorderLayout и т.д.
"*"-включение всех элементов библиотеки awt */	


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
	
					frame.setVisible(true); //устанавливаем что окно Index (Расчет расхода топлива) видно пользователю

				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}
	
	
	private JPanel panel, panel1;//панели на которых располагаются поля и кнопки. Панели доступны только для данного класса (private)
	private JButton calc;// кнопка Рассчитать которая доступна только для данного класса
	private JLabel label_1,label_2,label_3, label_4,label_n,sum_n,sum;// компонент на котором располагается текст
	public static JTextField sum_ok;
	/* текстовые поля в которые пользователь вводит данные, доступны для любого файла из пакета pack */
	public static JRadioButton rad_13, rad_15, rad_30, rad_35;/* компонент переключатель (при нажатии на одну из 
	таких кнопок ранее нажатая кнопка возвращается в исходное состояние)*/
	public static int int_rad=13;
	
	public index() { 
		setTitle("Калькулятор НДФЛ"); //устанавливает название окна 
		setSize(320, 240); // указывает ширину и высоту.
		setLocationRelativeTo(null);//установить посередине экрана
		
		//по закрытию формы - закрывать приложение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout (new BorderLayout()); 

        panel = new JPanel();//Панель на которой  располагаются текстовые поля и поля для ввода текста
		panel1 = new JPanel();//Панель на которой располагается кнопка

		add(panel, BorderLayout.CENTER);//Добавление панели panel по центру
		add(panel1, BorderLayout.SOUTH);//Добавление панели panel1 снизу

		panel.setBorder(new EmptyBorder(10,10,10,10));//установка внутренних отступов
		panel1.setBorder(new EmptyBorder(10,10,10,10));//установка внутренних отступов
	
		/* установка менеджера компоновки GridLayout. данный менеджер компоновки располагает компоненты в 
		 * таблицу */
		panel.setLayout(new GridLayout(6,2,15,0));/* на панели 6 строк,2столбца,15 - расстояние между столбцами,  0- между строками  */
		panel1.setLayout(new GridLayout(1,1));//на панели 1 строка,1столбец, будет расположена кнопка

		label_1 = new JLabel("Сумма оклада, руб.", JLabel.LEFT);
		label_2 = new JLabel("Налоговая ставка", JLabel.LEFT);
		label_3 = new JLabel("Сумма налога, руб.", JLabel.LEFT);
		label_4 = new JLabel("Сумма на руки, руб.", JLabel.LEFT);
		label_n = new JLabel("");
		sum_n = new JLabel("", JLabel.CENTER);
		sum = new JLabel("", JLabel.CENTER);
		/*Обозначаем что переменные Label_1,Label_2..являются объектом JLabel и указываем какой текст будет выводиться.
		JLabel.LEFT - выравнивание по левому краю,
		JLabel.CENTER - выравнивание по центру
		*/
		
		calc = new JButton("Рассчитать"); //В скобках - надпись на кнопке
	
		sum_ok = new JTextField();
		//выравнивание текста по центру
		sum_ok.setHorizontalAlignment(JTextField.CENTER); 
		sum_ok.setMargin(new Insets(2, 5, 2, 5));//установка внутренних отступов для текстового поля (2-верхний отступ, 5-левый, 2-нижний, 5-правый)

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

		//Добавление компонентов JRadioButton, JLabel, JTextField на панель panel
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
		panel1.add(calc);//Добавление кнопки на панель panel1
		//Добавление компонентов JLabel, JTextField на панель panel,panel1,panel2

		rad_13.addActionListener(new ActionListener()
        {
			/* 	rad_13 - компонент переключатель
	 		"."  - указывает к какой переменной следует применить слушателя.
	 		addActionListener - добавление слушателя ActionListener к переключателю
	  		new - Оператор new создает экземпляр указанного класса 
	  		(Для того чтобы кнопки стали функциональными, каждой из них необходимо присвоить обработчик событий, 
	  		который будет отвечать за реагирование на события. 
	  		В нашем случае требуется идентифицировать событие нажатия на переключатель – путем щелчка мышью. 
	  		Поэтому будет использоваться интерфейс "ActionListener", 
	  		предназначенный для обработки событий "ActionEvent".
	  		тело интерфейса указывается ниже после фигурной скобки "{"
	  		*/ 
			 public void actionPerformed(ActionEvent e)
	            {
	            	
	                int_rad=13; 
	    			sum_n.setText("");//очистить текстовое поле
	    			sum.setText("");
	            }
	        });
			rad_15.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=15; 
	    			sum_n.setText("");//очистить текстовое поле
	    			sum.setText("");
	            }
	        });
			rad_30.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=30; 
	    			sum_n.setText("");//очистить текстовое поле
	    			sum.setText("");
	            }
	        });
			rad_35.addActionListener(new ActionListener()
	        { public void actionPerformed(ActionEvent e)
	            {
	                int_rad=35; 
	    			sum_n.setText("");//очистить текстовое поле
	    			sum.setText("");
	            }
	        });
			
			calc.addActionListener(new ActionListener()   
	    			
	    	   {                                                         
	    	    public void actionPerformed(ActionEvent e)   
	    	   
	    	    {  
		    		
	    	    	if (isValidInput(sum_ok, "сумму оклада")) {
		    		
	    	    		double d_sum_ok= Double.parseDouble(sum_ok.getText().replace(',','.'));
	    	    	
	    	    		double d_sum_n = d_sum_ok/100*int_rad;//расчет сумма налога
	    	    		double d_sum = d_sum_ok-d_sum_n;//расчет сумма на руки

	    	    		String s_sum_n = String.format("%.2f", d_sum_n);
	    	    		    
	    	    		sum_n.setText(s_sum_n); /* Записываем строковую переменную в поля Jlabel */
	    	    		String s_sum = String.format("%.2f", d_sum);
	    	    		sum.setText(s_sum); /* Записываем строковую переменную в поля Jlabel */ 	    		
	    	    	}
	    	    	}   	    	                             
	    	   }); 
		}	
	//проверка данных, введенных пользователем
    public static boolean isValidInput(JTextField jtxt, String description) {

        JDialog D = new JDialog();
		//если был введен какой-либо текст
        if (jtxt.getText().trim().length() > 0) {
            //проверка на ввод только целого числа
            try { 
              
                 double num = Double.parseDouble(jtxt.getText().replace(',','.')); //попытка преобразовать текст в целое число      
                return true; //если все нормально - возвращаем true

            } catch (NumberFormatException e) {
            	

                //расположить курсор в текстовое поле, чтобы пользователь еще раз ввел число
                jtxt.requestFocus();
                jtxt.setText("");//очистить текстовое поле
   			
                //предупреждение - неверный формат числа
                JOptionPane.showMessageDialog(D, "Вы должны ввести число!", "Ошибка", JOptionPane.WARNING_MESSAGE);

                return false;//ошибка - возвращаем false
            }

        } else {// если пользователь не ввели никаких данных

            //предупреждение, что нужно ввести данные
            JOptionPane.showMessageDialog(D, "Введите " + description, "Ошибка", JOptionPane.WARNING_MESSAGE);

            //расположить курсор в текстово окне, чтобы пользователь еще раз ввел число
            jtxt.requestFocus();
            jtxt.selectAll();//очистить текстовое поле

            //ошибка - возвращаем false
            return false;
        }
    }	

}