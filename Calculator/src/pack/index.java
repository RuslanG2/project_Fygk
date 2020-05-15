package pack;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

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

					 
//
           

}}
