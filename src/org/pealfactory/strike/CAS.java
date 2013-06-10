package org.pealfactory.strike;

import org.pealfactory.strike.analyser.*;
import org.pealfactory.strike.ui.*;
import org.pealfactory.strike.audio.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.*;

/**
 * CAS - Computer Analysis of Striking
 * <p>
 * Copyright 2003-2012 Mark B Davies
 * </p>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * </p>
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * </p>
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 *
 * @author MBD
 */
public class CAS extends JApplet implements CASContainer
{
	/**
	 * Auto-generated Serial ID
	 */
	private static final long serialVersionUID = 5293270503686912839L;


	final static String LOWNDES_TEST_DATA="#. Lowndes: Version 2 (support comments in the file)\n#. Creator: Hawkear Version 0.6\n#. TranscriptionDate: 2013-03-05--20-29\n#. FirstBlowMs: 2830\nH 1 0X0000\nH 2 0X00e6\nH 3 0X024e\nH 4 0X032a\nH 5 0X0406\nH 6 0X0528\nH 7 0X05a0\nH 8 0X06a4\nH 9 0X07b2\nH O 0X08ac\nH E 0X09a6\nH T 0X0b04\nH 1 0X0b2c\nH 2 0X0bfe\nH 3 0X0d48\nH 4 0X0de8\nH 5 0X0ea6\nH 6 0X0f6e\nH 7 0X1036\nH 8 0X1112\nH 9 0X11a8\nH O 0X1270\nH E 0X1310\nH T 0X1496\nH 1 0X163a\nH 2 0X16f8\nH 3 0X1806\nH 4 0X1892\nH 5 0X1982\nH 6 0X1a68\nH 7 0X1b30\nH 8 0X1bf8\nH 9 0X1c8e\nH O 0X1d9c\nH E 0X1de2\nH T 0X1ee6\nH 1 0X201c\nH 2 0X20e4\nH 3 0X2206\nH 4 0X2288\nH 5 0X2300\nH 6 0X23fa\nH 7 0X249a\nH 8 0X2580\nH 9 0X25ee\nH O 0X2706\nH E 0X27ce\nH T 0X28d2\nH 1 0X2a4e\nH 2 0X2b0c\nH 3 0X2c2e\nH 4 0X2c92\nH 5 0X2d64\nH 6 0X2e2c\nH 7 0X2ee0\nH 8 0X2f9e\nH 9 0X307a\nH O 0X3156\nH E 0X3214\nH T 0X335e\nH 1 0X33ae\nH 2 0X3462\nH 3 0X3598\nH 4 0X3624\nH 5 0X36ba\nH 6 0X37be\nH 7 0X380e\nH 8 0X38ea\nH 9 0X39a8\nH O 0X3a84\nH E 0X3b42\nH T 0X3caa\nH 1 0X3e12\nH 2 0X3ec6\nH 3 0X3fb6\nH 4 0X4056\nH 5 0X40ec\nH 6 0X41aa\nH 7 0X4254\nH 8 0X4330\nH 9 0X43f8\nH O 0X44de\nH E 0X457e\nH T 0X46a0\nH 1 0X475e\nH 2 0X4826\nH 3 0X4934\nH 4 0X49b6\nH 5 0X4a42\nH 6 0X4b46\nH 7 0X4bb4\nH 8 0X4c90\nH 9 0X4d26\nH O 0X4e02\nH E 0X4ed4\nH T 0X4fe2\nH 1 0X5172\nH 2 0X5230\nH 3 0X5320\nH 4 0X53a2\nH 5 0X544c\nH 6 0X54ec\nH 7 0X55a0\nH 8 0X567c\nH 9 0X5744\nH O 0X5816\nH E 0X58f2\nH T 0X59f6\nH 1 0X5aaa\nH 2 0X5b5e\nH 3 0X5c6c\nH 4 0X5d16\nH 5 0X5d8e\nH 6 0X5e74\nH 7 0X5ef6\nH 8 0X5f96\nH 9 0X6072\nH O 0X6158\nH E 0X6220\nH T 0X6324\nH 1 0X64be\nH 2 0X6586\nH 3 0X668a\nH 4 0X672a\nH 5 0X67e8\nH 6 0X68b0\nH 7 0X6914\nH 8 0X69d2\nH 9 0X6a7c\nH O 0X6b4e\nH E 0X6c2a\nH T 0X6cd4\nH 1 0X6df6\nH 2 0X6eb4\nH 3 0X6f90\nH 4 0X704e\nH 5 0X70ee\nH 6 0X71d4\nH 7 0X7242\nH 8 0X72f6\nH 9 0X73d2\nH O 0X74ae\nH E 0X754e\nH T 0X763e\nH 1 0X77ce\nH 2 0X7882\nH 3 0X7986\nH 4 0X7a1c\nH 5 0X7ae4\nH 6 0X7ba2\nH 7 0X7c24\nH 8 0X7cec\nH 9 0X7da0\nH O 0X7e86\nH E 0X7f58\nH T 0X802a\nH 1 0X80f2\nH 2 0X81ba\nH 3 0X82c8\nH 4 0X8354\nH 5 0X83f4\nH 6 0X84d0\nH 7 0X8570\nH 8 0X8606\nH 9 0X86ec\nH O 0X87aa\nH E 0X8868\nH T 0X8980\nH 1 0X8b06\nH 2 0X8bba\nH 3 0X8cbe\nH 4 0X8d40\nH 5 0X8e08\nH 6 0X8e94\nH 7 0X8f70\nH 8 0X9024\nH 9 0X90d8\nH O 0X91a0\nH E 0X927c\nH T 0X936c\nH 1 0X9434\nH 2 0X94f2\nH 3 0X960a\nH 4 0X9696\nH 5 0X970e\nH 6 0X97ea\nH 7 0X98b2\nH 8 0X995c\nH 9 0X9a38\nH O 0X9b0a\nH E 0X9baa\nH T 0X9cae\nH 1 0X9e3e\nH 2 0X9f06\nH 3 0X9fd8\nH 4 0Xa078\nH 5 0Xa122\nH 6 0Xa1e0\nH 7 0Xa294\nH 8 0Xa366\nH 9 0Xa438\nH O 0Xa4f6\nH E 0Xa5be\nH T 0Xa69a\nH 1 0Xa762\nH 2 0Xa83e\nH 3 0Xa938\nH 4 0Xa9ce\nH 5 0Xaa5a\nH 6 0Xab22\nH 7 0Xabd6\nH 8 0Xac8a\nH 9 0Xad66\nH O 0Xae42\nH E 0Xaf00\nH T 0Xafdc\nH 1 0Xb16c\nH 2 0Xb234\nH 3 0Xb32e\nH 4 0Xb39c\nH 5 0Xb446\nH 6 0Xb4f0\nH 7 0Xb5e0\nH 8 0Xb694\nH 9 0Xb752\nH O 0Xb81a\nH E 0Xb91e\nH T 0Xb9dc\nH 1 0Xbac2\nH 2 0Xbb94\nH 3 0Xbc7a\nH 4 0Xbd06\nH 5 0Xbd6a\nH 6 0Xbe3c\nH 7 0Xbf22\nH 8 0Xbfae\nH 9 0Xc0b2\nH O 0Xc184\nH E 0Xc21a\nH T 0Xc30a\nH 1 0Xc4c2\nH 2 0Xc594\nH 3 0Xc67a\nH 4 0Xc706\nH 5 0Xc788\nH 6 0Xc846\nH 7 0Xc90e\nH 8 0Xc9d6\nH 9 0Xca8a\nH O 0Xcb48\nH E 0Xcc38\nH T 0Xccf6\nH 1 0Xcdfa\nH 2 0Xceb8\nH 3 0Xcf80\nH 4 0Xd016\nH 5 0Xd0ac\nH 6 0Xd174\nH 7 0Xd250\nH 8 0Xd2f0\nH 9 0Xd3e0\nH O 0Xd4a8\nH E 0Xd552\nH T 0Xd638\nH 1 0Xd80e\nH 2 0Xd8c2\nH 3 0Xd980\nH 4 0Xda02\nH 5 0Xda8e\nH 6 0Xdb74\nH 7 0Xdc28\nH 8 0Xdcc8\nH 9 0Xdd9a\nH O 0Xde44\nH E 0Xdf3e\nH T 0Xe010\nH 1 0Xe10a\nH 2 0Xe1be\nH 3 0Xe29a\nH 4 0Xe33a\nH 5 0Xe3c6\nH 6 0Xe4ac\nH 7 0Xe56a\nH 8 0Xe5ec\nH 9 0Xe6e6\nH O 0Xe79a\nH E 0Xe844\nH T 0Xe97a\nH 1 0Xeaec\nH 2 0Xeb96\nH 3 0Xec4a\nH 4 0Xecf4\nH 5 0Xeda8\nH 6 0Xeea2\nH 7 0Xef6a\nH 8 0Xefec\nH 9 0Xf0be\nH O 0Xf15e\nH E 0Xf244\nH T 0Xf384\nH 1 0Xf410\nH 2 0Xf4d8\nH 3 0Xf5aa\nH 4 0Xf640\nH 5 0Xf6c2\nH 6 0Xf7bc\nH 7 0Xf884\nH 8 0Xf8f2\nH 9 0Xf9ec\nH O 0Xfaa0\nH E 0Xfb54\nH T 0Xfc58\nH 1 0Xfdf2\nH 2 0Xfeba\nH 3 0Xffa0\nH 4 0X0036\nH 5 0X00f4\nH 6 0X019e\nH 7 0X0298\nH 8 0X0306\nH 9 0X03d8\nH O 0X046e\nH E 0X055e\nH T 0X066c\nH 1 0X0702\nH 2 0X0810\nH 3 0X08ce\nH 4 0X0978\nH 5 0X0a4a\nH 6 0X0ad6\nH 7 0X0bbc\nH 8 0X0c3e\nH 9 0X0d10\nH O 0X0dc4\nH E 0X0e6e\nH T 0X0f86\nH 1 0X1134\nH 2 0X11de\nH 3 0X12b0\nH 4 0X1346\nH 5 0X1422\nH 6 0X14f4\nH 7 0X15b2\nH 8 0X1652\nH 9 0X172e\nH O 0X17d8\nH E 0X1882\nH T 0X1968\nH 1 0X1a44\nH 2 0X1af8\nH 3 0X1bca\nH 4 0X1c7e\nH 5 0X1d46\nH 6 0X1e0e\nH 7 0X1ed6\nH 8 0X1f58\nH 9 0X2048\nH O 0X20fc\nH E 0X21b0\nH T 0X22c8\nH 1 0X2444\nH 2 0X24f8\nH 3 0X2598\nH 4 0X264c\nH 5 0X270a\nH 6 0X27e6\nH 7 0X28a4\nH 8 0X293a\nH 9 0X2a2a\nH O 0X2ad4\nH E 0X2b9c\nH T 0X2caa\nH 1 0X2d40\nH 2 0X2e08\nH 3 0X2ed0\nH 4 0X2f98\nH 5 0X3024\nH 6 0X313c\nH 7 0X31dc\nH 8 0X325e\nH 9 0X3358\nH O 0X3416\nH E 0X34b6\nH T 0X35ec\nH 1 0X374a\nH 2 0X37fe\nH 3 0X38d0\nH 4 0X397a\nH 5 0X3a1a\nH 6 0X3ad8\nH 7 0X3b96\nH 8 0X3c4a\nH 9 0X3d30\nH O 0X3dee\nH E 0X3ec0\nH T 0X3fa6\nH 1 0X4064\nH 2 0X4140\nH 3 0X4212\nH 4 0X42da\nH 5 0X4384\nH 6 0X4442\nH 7 0X4500\nH 8 0X4578\nH 9 0X467c\nH O 0X4726\nH E 0X47da\nH T 0X48f2\nH 1 0X4a82\nH 2 0X4b22\nH 3 0X4bfe\nH 4 0X4c94\nH 5 0X4d5c\nH 6 0X4e06\nH 7 0X4ee2\nH 8 0X4f96\nH 9 0X505e\nH O 0X5108\nH E 0X51bc\nH T 0X52d4\nH 1 0X539c\nH 2 0X545a\nH 3 0X5522\nH 4 0X55e0\nH 5 0X568a\nH 6 0X5748\nH 7 0X5810\nH 8 0X58ba\nH 9 0X59aa\nH O 0X5a54\nH E 0X5b08\nH T 0X5be4\nH 1 0X5d9c\nH 2 0X5e46\nH 3 0X5f18\nH 4 0X5fae\nH 5 0X608a\nH 6 0X6166\nH 7 0X622e\nH 8 0X62ba\nH 9 0X63a0\nH O 0X6454\nH E 0X64ea\nH T 0X65d0\nH 1 0X66a2\nH 2 0X6760\nH 3 0X6846\nH 4 0X68fa\nH 5 0X69a4\nH 6 0X6a8a\nH 7 0X6b0c\nH 8 0X6bd4\nH 9 0X6cd8\nH O 0X6d96\nH E 0X6e40\nH T 0X6f26\nH 1 0X7098\nH 2 0X7160\nH 3 0X721e\nH 4 0X72b4\nH 5 0X7386\nH 6 0X7462\nH 7 0X7516\nH 8 0X75ca\nH 9 0X76a6\nH E 0X775a\nH O 0X782c\nH T 0X78f4\nH 1 0X79b2\nH 2 0X7a70\nH 3 0X7b38\nH 4 0X7bec\nH 5 0X7caa\nH 6 0X7d7c\nH 7 0X7e12\nH 8 0X7ef8\nH 9 0X7fca\nH E 0X807e\nH O 0X8178\nH T 0X8236\nH 1 0X83b2\nH 2 0X8484\nH 3 0X8538\nH 4 0X85d8\nH 5 0X86be\nH 6 0X8772\nH 7 0X881c\nH 9 0X8966\nH 8 0X89ca\nH E 0X8a60\nH O 0X8b3c\nH T 0X8c2c\nH 1 0X8cc2\nH 2 0X8d80\nH 3 0X8e70\nH 4 0X8f06\nH 5 0X8fa6\nH 6 0X90a0\nH 7 0X9122\nH 9 0X91e0\nH 8 0X929e\nH E 0X9384\nH O 0X947e\nH T 0X9550\nH 1 0X969a\nH 2 0X9776\nH 3 0X9852\nH 4 0X98f2\nH 5 0X9a00\nH 6 0X9a82\nH 7 0X9b40\nH 9 0X9c08\nH E 0X9cb2\nH 8 0X9d84\nH O 0X9de8\nH T 0X9ef6\nH 1 0X9ffa\nH 2 0Xa0b8\nH 3 0Xa19e\nH 4 0Xa234\nH 5 0Xa2ca\nH 6 0Xa3b0\nH 7 0Xa45a\nH 9 0Xa504\nH E 0Xa5e0\nH 8 0Xa66c\nH O 0Xa752\nH T 0Xa810\nH 1 0Xa9b4\nH 2 0Xaa9a\nH 3 0Xab8a\nH 4 0Xac20\nH 5 0Xacca\nH 6 0Xad92\nH 7 0Xae5a\nH 9 0Xaeb4\nH E 0Xafd6\nH 8 0Xb03a\nH O 0Xb12a\nH T 0Xb224\nH 1 0Xb2e2\nH 2 0Xb3b4\nH 3 0Xb4a4\nH 4 0Xb544\nH 5 0Xb5f8\nH 6 0Xb6b6\nH 7 0Xb756\nH 9 0Xb814\nH E 0Xb8d2\nH 8 0Xb968\nH O 0Xba62\nH T 0Xbb2a\nH 1 0Xbcd8\nH 2 0Xbda0\nH 3 0Xbe5e\nH 4 0Xbef4\nH 5 0Xbfbc\nH 6 0Xc084\nH 7 0Xc142\nH 9 0Xc1e2\nH E 0Xc2d2\nH 8 0Xc340\nH O 0Xc408\nH T 0Xc552\nH 1 0Xc5e8\nH 2 0Xc6c4\nH 3 0Xc7d2\nH 4 0Xc854\nH 5 0Xc8cc\nH 6 0Xc99e\nH 7 0Xca48\nH 9 0Xcb1a\nH E 0Xcbd8\nH 8 0Xcc6e\nH O 0Xcd54\nH T 0Xce6c\nH 1 0Xcfe8\nH 2 0Xd09c\nH 3 0Xd178\nH 4 0Xd204\nH 5 0Xd312\nH 6 0Xd3d0\nH 7 0Xd48e\nH 9 0Xd538\nH E 0Xd5ec\nH 8 0Xd664\nH O 0Xd736\nH T 0Xd830\nH 1 0Xd8f8\nH 2 0Xd9c0\nH 3 0Xda74\nH 4 0Xdb5a\nH 5 0Xdc18\nH 6 0Xdce0\nH 7 0Xdd8a\nH 9 0Xde52\nH E 0Xdef2\nH 8 0Xdfb0\nH O 0Xe082\nH T 0Xe154\nH 1 0Xe316\nH 2 0Xe3ca\nH 3 0Xe4a6\nH 4 0Xe546\nH 5 0Xe618\nH 7 0Xe6b8\nH 6 0Xe78a\nH 9 0Xe82a\nH E 0Xe8fc\nH 8 0Xe974\nH O 0Xea5a\nH T 0Xeb68\nH 1 0Xec44\nH 2 0Xed02\nH 3 0Xed7a\nH 4 0Xee60\nH 5 0Xef28\nH 7 0Xefd2\nH 6 0Xf0b8\nH 9 0Xf14e\nH E 0Xf202\nH 8 0Xf298\nH O 0Xf392\nH T 0Xf478\nH 1 0Xf644\nH 2 0Xf6e4\nH 3 0Xf784\nH 4 0Xf838\nH 5 0Xf900\nH 7 0Xf9c8\nH 9 0Xfaa4\nH 6 0Xfb76\nH E 0Xfbee\nH 8 0Xfc5c\nH O 0Xfd4c\nH T 0Xfe78\nH 1 0Xff68\nH 2 0X001c\nH 3 0X00e4\nH 4 0X01a2\nH 5 0X022e\nH 7 0X02e2\nH 9 0X03d2\nH 6 0X04a4\nH E 0X0530\nH 8 0X05a8\nH O 0X06a2\nH T 0X0788\nH 1 0X0936\nH 2 0X09f4\nH 3 0X0ae4\nH 4 0X0b84\nH 5 0X0c2e\nH 7 0X0cec\nH 9 0X0da0\nH E 0X0e72\nH 6 0X0f76\nH 8 0X1002\nH O 0X10d4\nH T 0X11ba\nH 1 0X123c\nH 2 0X1304\nH 3 0X1408\nH 4 0X14a8\nH 5 0X153e\nH 7 0X1606\nH 9 0X16d8\nH E 0X1778\nH 6 0X1868\nH 8 0X1926\nH O 0X1a20\nH T 0X1aac\nH 1 0X1c6e\nH 2 0X1d2c\nH 3 0X1df4\nH 4 0X1ea8\nH 5 0X1f3e\nH 7 0X2006\nH 9 0X20e2\nH E 0X2196\nH 6 0X227c\nH 8 0X2326\nH O 0X242a\nH T 0X24ac\nH 1 0X2588\nH 2 0X263c\nH 3 0X2718\nH 4 0X27cc\nH 5 0X2880\nH 7 0X292a\nH 9 0X2a06\nH E 0X2ab0\nH 6 0X2b6e\nH 8 0X2c2c\nH O 0X2d6c\nH T 0X2dd0\nH 1 0X2fb0\nH 2 0X3064\nH 3 0X3140\nH 4 0X31d6\nH 5 0X328a\nH 7 0X333e\nH 9 0X33e8\nH E 0X34ba\nH 6 0X3564\nH 8 0X364a\nH O 0X3726\nH T 0X37bc\nH 1 0X38c0\nH 2 0X3988\nH 3 0X3a46\nH 4 0X3afa\nH 5 0X3b86\nH 7 0X3c76\nH 9 0X3d3e\nH E 0X3df2\nH 6 0X3e74\nH 8 0X3f1e\nH O 0X4068\nH T 0X4112\nH 1 0X42ca\nH 2 0X437e\nH 3 0X4432\nH 4 0X44e6\nH 5 0X4590\nH 7 0X4644\nH 9 0X4702\nH E 0X4810\nH 6 0X487e\nH 8 0X495a\nH O 0X49fa\nH T 0X4b3a\nH 1 0X4bb2\nH 2 0X4c8e\nH 3 0X4d9c\nH 4 0X4e28\nH 5 0X4ee6\nH 7 0X4f90\nH 9 0X5062\nH E 0X5120\nH 6 0X51a2\nH 8 0X5256\nH O 0X5332\nH T 0X544a\nH 1 0X55d0\nH 2 0X5698\nH 3 0X576a\nH 5 0X581e\nH 4 0X58c8\nH 7 0X597c\nH 9 0X5a30\nH E 0X5b0c\nH 6 0X5bfc\nH 8 0X5cba\nH O 0X5d28\nH T 0X5e4a\nH 1 0X5ee0\nH 2 0X5fb2\nH 3 0X60a2\nH 5 0X6156\nH 4 0X6228\nH 7 0X62a0\nH 9 0X637c\nH E 0X6426\nH 6 0X64ee\nH 8 0X65c0\nH O 0X6692\nH T 0X6778\nH 1 0X68ea\nH 2 0X69a8\nH 3 0X6a98\nH 5 0X6b1a\nH 4 0X6be2\nH 7 0X6cbe\nH 9 0X6d90\nH E 0X6e58\nH 6 0X6f20\nH 8 0X6fde\nH O 0X7074\nH T 0X7196\nH 1 0X7218\nH 2 0X72e0\nH 3 0X73d0\nH 5 0X7416\nH 4 0X752e\nH 7 0X75ec\nH 9 0X76be\nH E 0X7772\nH 6 0X7812\nH 8 0X78d0\nH O 0X79a2\nH T 0X7ac4\nH 1 0X7c5e\nH 2 0X7d26\nH 3 0X7e16\nH 5 0X7eb6\nH 7 0X7f6a\nH 4 0X801e\nH 9 0X8096\nH E 0X817c\nH 6 0X8258\nH 8 0X830c\nH O 0X838e\nH T 0X84d8\nH 1 0X8578\nH 2 0X8654\nH 3 0X8758\nH 5 0X87c6\nH 7 0X88ac\nH 4 0X8988\nH 9 0X8a0a\nH E 0X8ad2\nH 6 0X8b86\nH 8 0X8c12\nH O 0X8cee\nH T 0X8e06\nH 1 0X8fa0\nH 2 0X9068\nH 3 0X914e\nH 5 0X91da\nH 7 0X92ca\nH 9 0X937e\nH 4 0X9446\nH E 0X94fa\nH 6 0X95ae\nH 8 0X964e\nH O 0X96ee\nH T 0X9810\nH 1 0X98a6\nH 2 0X9964\nH 3 0X9a9a\nH 5 0X9afe\nH 7 0X9bf8\nH 9 0X9cac\nH 4 0X9d92\nH E 0X9e3c\nH 6 0X9edc\nH 8 0X9f68\nH O 0Xa044\nH T 0Xa13e\nH 1 0Xa300\nH 2 0Xa3aa\nH 3 0Xa486\nH 5 0Xa53a\nH 7 0Xa620\nH 9 0Xa6a2\nH E 0Xa79c\nH 4 0Xa864\nH 6 0Xa904\nH 8 0Xa990\nH O 0Xaa3a\nH T 0Xab52\nH 1 0Xac24\nH 2 0Xacec\nH 3 0Xaddc\nH 5 0Xae4a\nH 7 0Xaf1c\nH 9 0Xafee\nH E 0Xb0a2\nH 4 0Xb19c\nH 6 0Xb232\nH 8 0Xb2aa\nH O 0Xb390\nH T 0Xb46c\nH 1 0Xb656\nH 2 0Xb70a\nH 3 0Xb7d2\nH 5 0Xb872\nH 7 0Xb944\nH 9 0Xb9ee\nH E 0Xbade\nH 4 0Xbb74\nH 6 0Xbc50\nH 8 0Xbd2c\nH O 0Xbdb8\nH T 0Xbe58\nH 1 0Xbf5c\nH 2 0Xc01a\nH 3 0Xc0f6\nH 5 0Xc18c\nH 7 0Xc24a\nH 9 0Xc33a\nH E 0Xc402\nH 4 0Xc4d4\nH 6 0Xc57e\nH 8 0Xc650\nH O 0Xc70e\nH T 0Xc7b8\nH 1 0Xc9a2\nH 2 0Xca4c\nH 3 0Xcb28\nH 5 0Xcbaa\nH 7 0Xcc90\nH 9 0Xcd58\nH E 0Xce2a\nH 4 0Xceb6\nH 6 0Xcf74\nH 8 0Xd050\nH O 0Xd0fa\nH T 0Xd23a\nH 1 0Xd29e\nH 2 0Xd366\nH 3 0Xd442\nH 5 0Xd4e2\nH 7 0Xd5b4\nH 9 0Xd686\nH E 0Xd758\nH 4 0Xd816\nH 6 0Xd8ac\nH 8 0Xd960\nH O 0Xda3c\nH T 0Xdb9a\nH 1 0Xdcd0\nH 2 0Xdd70\nH 3 0Xde38\nH 5 0Xdf1e\nH 7 0Xe004\nH 9 0Xe0ae\nH E 0Xe18a\nH 4 0Xe20c\nH 6 0Xe2b6\nH 8 0Xe39c\nH O 0Xe432\nH T 0Xe554\nH 1 0Xe5fe\nH 2 0Xe6c6\nH 3 0Xe766\nH 5 0Xe842\nH 7 0Xe90a\nH 9 0Xe9f0\nH E 0Xeacc\nH 4 0Xeb80\nH 6 0Xec16\nH 8 0Xecc0\nH O 0Xed9c\nH T 0Xeeb4\nH 1 0Xf026\nH 2 0Xf0ee\nH 3 0Xf1a2\nH 5 0Xf256\nH 7 0Xf33c\nH 9 0Xf3fa\nH E 0Xf4fe\nH 4 0Xf59e\nH 6 0Xf62a\nH 8 0Xf706\nH O 0Xf7b0\nH T 0Xf8be\nH 1 0Xf936\nH 2 0Xfa08\nH 3 0Xfada\nH 5 0Xfb48\nH 7 0Xfc38\nH 9 0Xfd32\nH E 0Xfe18\nH 4 0Xfee0\nH 6 0Xff80\nH 8 0X002a\nH O 0X0106\nH T 0X01ce\nH 1 0X035e\nH 3 0X04b2\nH 2 0X04f8\nH 5 0X05ac\nH 7 0X06c4\nH 9 0X071e\nH E 0X082c\nH 4 0X08cc\nH 6 0X0980\nH 8 0X0a3e\nH O 0X0af2\nH T 0X0c14\nH 1 0X0ca0\nH 3 0X0da4\nH 2 0X0e30\nH 5 0X0eda\nH 7 0X0fd4\nH 9 0X1088\nH E 0X1146\nH 4 0X1222\nH 6 0X12c2\nH 8 0X1344\nH O 0X1448\nH T 0X1538\nH 1 0X16c8\nH 3 0X17a4\nH 5 0X186c\nH 2 0X192a\nH 7 0X1a06\nH 9 0X1a7e\nH E 0X1b6e\nH 4 0X1c0e\nH 6 0X1cb8\nH 8 0X1d9e\nH O 0X1e66\nH T 0X1f4c\nH 1 0X201e\nH 3 0X2140\nH 5 0X219a\nH 2 0X2262\nH 7 0X2334\nH 9 0X23b6\nH E 0X24a6\nH 4 0X256e\nH 6 0X2604\nH 8 0X26d6\nH O 0X27bc\nH T 0X28a2\nH 1 0X2a3c\nH 3 0X2b4a\nH 5 0X2c12\nH 7 0X2cc6\nH 2 0X2d8e\nH 9 0X2e1a\nH E 0X2f0a\nH 4 0X2fb4\nH 6 0X3040\nH 8 0X311c\nH O 0X31d0\nH T 0X32d4\nH 1 0X3392\nH 3 0X34a0\nH 5 0X3522\nH 7 0X35f4\nH 2 0X36b2\nH 9 0X375c\nH E 0X3824\nH 4 0X3932\nH 6 0X39b4\nH 8 0X3a5e\nH O 0X3b30\nH T 0X3c02\nH 1 0X3dba\nH 3 0X3e96\nH 5 0X3f5e\nH 7 0X4026\nH 9 0X40ee\nH 2 0X41b6\nH E 0X4260\nH 4 0X4314\nH 6 0X43a0\nH 8 0X449a\nH O 0X454e\nH T 0X4620\nH 1 0X471a\nH 3 0X481e\nH 5 0X486e\nH 7 0X494a\nH 9 0X4a08\nH 2 0X4aee\nH E 0X4bb6\nH 4 0X4c74\nH 6 0X4d14\nH 8 0X4dd2\nH O 0X4ea4\nH T 0X4f6c\nH 1 0X5142\nH 3 0X5250\nH 5 0X5304\nH 7 0X53ae\nH 9 0X543a\nH E 0X5516\nH 2 0X55e8\nH 4 0X56b0\nH 6 0X5764\nH 8 0X582c\nH O 0X58c2\nH T 0X59c6\nH 1 0X5a84\nH 3 0X5be2\nH 5 0X5c5a\nH 7 0X5cfa\nH 9 0X5db8\nH E 0X5e4e\nH 2 0X5f2a\nH 4 0X6038\nH 6 0X60ba\nH 8 0X6164\nH O 0X622c\nH T 0X62fe\nH 1 0X64c0\nH 3 0X6574\nH 5 0X6646\nH 7 0X670e\nH 9 0X67fe\nH E 0X68bc\nH 2 0X69a2\nH 4 0X6a4c\nH 6 0X6b00\nH 8 0X6bb4\nH O 0X6c5e\nH T 0X6d62\nH 1 0X6e16\nH 3 0X6efc\nH 5 0X6f6a\nH 7 0X7028\nH 9 0X7122\nH E 0X71fe\nH 2 0X72b2\nH 4 0X73ac\nH 6 0X741a\nH 8 0X7500\nH O 0X75c8\nH T 0X7690\nH 1 0X7848\nH 3 0X7906\nH 5 0X79c4\nH 7 0X7aa0\nH 9 0X7b36\nH E 0X7c1c\nH 2 0X7cee\nH 4 0X7dac\nH 6 0X7e60\nH 8 0X7f46\nH O 0X800e\nH T 0X8108\nH 1 0X8194\nH 3 0X8270\nH 5 0X8284\nH 7 0X839c\nH 9 0X848c\nH E 0X855e\nH 2 0X8630\nH 4 0X870c\nH 6 0X87a2\nH 8 0X8860\nH O 0X8964\nH T 0X8a2c\nH 1 0X8be4\nH 3 0X8cb6\nH 5 0X8d92\nH 7 0X8e28\nH 9 0X8ed2\nH E 0X8f9a\nH 2 0X9080\nH 4 0X912a\nH 6 0X91de\nH 8 0X92a6\nH O 0X9346\nH T 0X944a\nH 1 0X9530\nH 3 0X963e\nH 5 0X96c0\nH 7 0X9792\nH 9 0X983c\nH E 0X9904\nH 2 0X99c2\nH 4 0X9aa8\nH 6 0X9b16\nH 8 0X9bc0\nH O 0X9cba\nH T 0X9d50\nH 1 0X9f4e\nH 3 0Xa03e\nH 5 0Xa0de\nH 7 0Xa1ba\nH 9 0Xa278\nH E 0Xa35e\nH 2 0Xa426\nH 4 0Xa4e4\nH 6 0Xa598\nH 8 0Xa642\nH O 0Xa6ec\nH T 0Xa7aa\nH 1 0Xa8a4\nH 3 0Xa9b2\nH 5 0Xaa16\nH 7 0Xab10\nH 9 0Xabb0\nH E 0Xac96\nH 2 0Xad5e\nH 4 0Xae26\nH 6 0Xaee4\nH 8 0Xaf7a\nH O 0Xb04c\nH T 0Xb0f6\nH 1 0Xb2ea\nH 3 0Xb3bc\nH 5 0Xb434\nH 7 0Xb506\nH 9 0Xb5ce\nH E 0Xb6aa\nH 2 0Xb786\nH 4 0Xb858\nH 6 0Xb90c\nH 8 0Xb9fc\nH O 0Xbaa6\nH T 0Xbba0\nH 1 0Xbc22\nH 3 0Xbcf4\nH 5 0Xbd94\nH 7 0Xbe7a\nH 9 0Xbf1a\nH E 0Xbff6\nH 2 0Xc0b4\nH 4 0Xc19a\nH 6 0Xc258\nH 8 0Xc316\nH O 0Xc3de\nH T 0Xc4f6\nH 1 0Xc690\nH 3 0Xc744\nH 5 0Xc7e4\nH 7 0Xc8ca\nH 9 0Xc97e\nH E 0Xca46\nH 2 0Xcb22\nH 4 0Xcbcc\nH 6 0Xcc6c\nH 8 0Xcd52\nH O 0Xcdfc\nH T 0Xcee2\nH 1 0Xcffa\nH 3 0Xd0ea\nH 5 0Xd14e\nH 7 0Xd220\nH 9 0Xd2c0\nH E 0Xd39c\nH 2 0Xd464\nH 4 0Xd554\nH 6 0Xd5b8\nH 8 0Xd680\nH O 0Xd766\nH T 0Xd810\nH 1 0Xd9fa\nH 3 0Xdaea\nH 5 0Xdb8a\nH 7 0Xdc48\nH 9 0Xdd10\nH E 0Xddc4\nH 2 0Xde96\nH 4 0Xdf5e\nH 6 0Xe030\nH 8 0Xe0f8\nH O 0Xe18e\nH T 0Xe26a\nH 1 0Xe350\nH 3 0Xe45e\nH 5 0Xe4c2\nH 7 0Xe576\nH 9 0Xe666\nH E 0Xe71a\nH 2 0Xe7b0\nH 4 0Xe8aa\nH 6 0Xe972\nH 8 0Xe9fe\nH O 0Xeaee\nH T 0Xebac\nH 1 0Xed50\nH 3 0Xee5e\nH 5 0Xeee0\nH 7 0Xefa8\nH 9 0Xf07a\nH E 0Xf17e\nH 2 0Xf232\nH 4 0Xf2f0\nH 6 0Xf3a4\nH 8 0Xf444\nH O 0Xf50c\nH T 0Xf5d4\nH 1 0Xf6ba\nH 3 0Xf7a0\nH 5 0Xf822\nH 7 0Xf8cc\nH 9 0Xf9c6\nH E 0Xfa98\nH 2 0Xfb6a\nH 4 0Xfc64\nH 6 0Xfce6\nH 8 0Xfd72\nH O 0Xfe76\nH T 0Xff3e\nH 1 0X00e2\nH 3 0X01a0\nH 5 0X022c\nH 7 0X0308\nH 9 0X03da\nH E 0X04ca\nH 2 0X05ba\nH 4 0X068c\nH 6 0X0718\nH 8 0X07d6\nH O 0X088a\nH T 0X095c\nH 1 0X0a38\nH 3 0X0b3c\nH 5 0X0b64\nH 7 0X0c36\nH 9 0X0d3a\nH E 0X0df8\nH 2 0X0eb6\nH 4 0X0f92\nH 6 0X1050\nH 8 0X10f0\nH O 0X11d6\nH T 0X1294\nH 1 0X1456\nH 3 0X151e\nH 5 0X15b4\nH 7 0X1672\nH 9 0X174e\nH E 0X182a\nH 2 0X18e8\nH 4 0X1992\nH 6 0X1a46\nH 8 0X1afa\nH O 0X1bcc\nH T 0X1d02\nH 1 0X1db6\nH 3 0X1ea6\nH 5 0X1ef6\nH 7 0X1f8c\nH 9 0X2090\nH E 0X2158\nH 2 0X222a\nH 4 0X2306\nH 6 0X239c\nH 8 0X2446\nH O 0X2518\nH T 0X2612\nH 1 0X27ac\nH 3 0X2892\nH 5 0X2932\nH 7 0X29f0\nH 9 0X2ac2\nH E 0X2b94\nH 2 0X2c66\nH 4 0X2d1a\nH 6 0X2dc4\nH 8 0X2e78\nH O 0X2f2c\nH T 0X2ffe\nH 1 0X30ee\nH 3 0X31de\nH 5 0X326a\nH 7 0X331e\nH 9 0X3404\nH E 0X34b8\nH 2 0X358a\nH 4 0X3666\nH 6 0X3706\nH 8 0X37a6\nH O 0X3896\nH T 0X390e\nH 1 0X3b0c\nH 3 0X3bac\nH 5 0X3c7e\nH 7 0X3d5a\nH 9 0X3e0e\nH E 0X3eea\nH 2 0X3fbc\nH 4 0X407a\nH 6 0X412e\nH 8 0X41ec\nH O 0X4296\nH T 0X4372\nH 1 0X4462\nH 3 0X44ee\nH 5 0X458e\nH 7 0X4642\nH 9 0X475a\nH E 0X480e\nH 2 0X48cc\nH 4 0X49bc\nH 6 0X4a52\nH 8 0X4ade\nH O 0X4be2\nH T 0X4cb4\nH 1 0X4e80\nH 3 0X4f20\nH 5 0X4fac\nH 7 0X5092\nH 9 0X515a\nH E 0X5222\nH 2 0X52f4\nH 4 0X53d0\nH 6 0X54a2\nH 8 0X5560\nH O 0X55ec\nH T 0X5704\nH 1 0X579a\nH 3 0X586c\nH 5 0X58bc\nH 7 0X5998\nH 9 0X5a9c\nH E 0X5b6e\nH 2 0X5c36\nH 4 0X5d12\nH 6 0X5da8\nH 8 0X5e34\nH O 0X5f42\nH T 0X6028\nH 1 0X61ea\nH 3 0X624e\nH 5 0X62f8\nH 7 0X63b6\nH 9 0X64a6\nH E 0X6582\nH 2 0X6654\nH 4 0X6712\nH 6 0X67bc\nH 8 0X6870\nH O 0X6938\nH T 0X6a64\nH 1 0X6b04\nH 3 0X6be0\nH 5 0X6c62\nH 7 0X6cd0\nH 9 0X6dde\nH E 0X6e9c\nH 2 0X6f64\nH 4 0X705e\nH 6 0X70fe\nH 8 0X71bc\nH O 0X72ac\nH T 0X7388\nH 1 0X7518\nH 3 0X75cc\nH 5 0X7662\nH 7 0X773e\nH 9 0X7810\nH E 0X78ec\nH 2 0X79b4\nH 4 0X7a68\nH 6 0X7b08\nH 8 0X7bda\nH O 0X7c84\nH T 0X7d60\nH 1 0X7e50\nH 3 0X7f22\nH 5 0X7f7c\nH 7 0X8076\nH 9 0X8152\nH E 0X821a\nH 2 0X82ec\nH 4 0X83b4\nH 6 0X8472\nH 8 0X8526\nH O 0X8602\nH T 0X86b6\nH 1 0X8878\nH 3 0X8922\nH 5 0X89cc\nH 7 0X8a9e\nH 9 0X8b52\nH E 0X8c4c\nH 2 0X8d14\nH 4 0X8dd2\nH 6 0X8e5e\nH 8 0X8f12\nH O 0X8fe4\nH T 0X90ca\nH 1 0X91a6\nH 3 0X9278\nH 5 0X92fa\nH 7 0X93b8\nH 9 0X94a8\nH E 0X957a\nH 2 0X9642\nH 4 0X9728\nH 6 0X97c8\nH 8 0X9868\nH O 0X9944\nH T 0X9a02\nH 1 0X9bf6\nH 3 0X9c82\nH 5 0X9d5e\nH 7 0X9e12\nH 9 0X9ed0\nH E 0X9f8e\nH 2 0Xa056\nH 4 0Xa11e\nH 6 0Xa1dc\nH 8 0Xa27c\nH O 0Xa330\nH T 0Xa420\nH 1 0Xa4f2\nH 3 0Xa5d8\nH 5 0Xa664\nH 7 0Xa722\nH 9 0Xa812\nH E 0Xa8da\nH 2 0Xa97a\nH 4 0Xaa6a\nH 6 0Xab00\nH 8 0Xaba0\nH O 0Xac9a\nH T 0Xad76\nH 1 0Xaefc\nH 3 0Xaf92\nH 5 0Xb05a\nH 7 0Xb140\nH 9 0Xb21c\nH E 0Xb2e4\nH 2 0Xb3ca\nH 4 0Xb47e\nH 6 0Xb550\nH 8 0Xb604\nH O 0Xb690\nH T 0Xb76c\nH 1 0Xb848\nH 3 0Xb924\nH 5 0Xb956\nH 7 0Xba5a\nH 9 0Xbb4a\nH E 0Xbc08\nH 2 0Xbce4\nH 4 0Xbdde\nH 6 0Xbe6a\nH 8 0Xbf14\nH O 0Xc018\nH T 0Xc0e0\nH 1 0Xc284\nH 3 0Xc324\nH 5 0Xc3e2\nH 7 0Xc4aa\nH 9 0Xc568\nH E 0Xc626\nH 2 0Xc70c\nH 4 0Xc7de\nH 6 0Xc87e\nH 8 0Xc928\nH O 0Xca04\nH T 0Xcb1c\nH 1 0Xcbbc\nH 3 0Xccca\nH 5 0Xcd24\nH 7 0Xce1e\nH 9 0Xcedc\nH E 0Xcf9a\nH 2 0Xd062\nH 4 0Xd152\nH 6 0Xd1ca\nH 8 0Xd2b0\nH 3 0Xd3b4\nH O 0Xd3be\nH T 0Xd47c\n";
	
	
	public final static double VERSION = 1.4;
	public final static boolean NOWORCESTER = false;
	public final static String APPLET_FILE_LIST = "files.lst";
	public final static String DEFAULT_FRAME_TITLE = "Computer Analysis of Striking";

	private CASWindow fWindow;

	private static File gHomeDirectory;

	public static void main(String[] args)
	{
		if (args==null || args.length>20)
		{
			System.out.println("Usage: CAS [file]");
			System.exit(1);
		}
		String toLoad = null;
		if (args.length>0)
			toLoad = args[0];
		try
		{
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e)
		{
			System.out.println("Unable to set Look and Feel: "+e);
		}
		CASFrame.openNewFrame(DEFAULT_FRAME_TITLE, toLoad, null);
	}

	public static synchronized File getHomeDirectory()
	{
		if (gHomeDirectory==null)
			gHomeDirectory = new File("peal.txt");
		return gHomeDirectory;
	}

	public static synchronized void setHomeDirectory(File homeDir)
	{
		gHomeDirectory = homeDir;
	}

	public static CASWindow createNewCASWindow(boolean fAppletMode)
	{
		CASWindow window = new CASWindow(fAppletMode);

		List<Visualiser> visualisers = getAvailableVisualisers();
		for (Visualiser v: visualisers)
			window.addVisualiser(v);

		//PlaybackController audio = PlaybackController.getWavPlaybackController();
		PlaybackController audio = PlaybackController.getMidiPlaybackController();
		if (audio!=null)
     	window.setPlaybackController(audio);

		return window;
	}

	public static List<Visualiser> getAvailableVisualisers()
	{
		List<Visualiser> visualisers = new ArrayList<Visualiser>();

		if (!NOWORCESTER)
		{
			visualisers.add(new RodVisualiser2());
			visualisers.add(new RodVisualiser5(1.0));
		}
		visualisers.add(new SimpleAveragedRowVisualiser(1.0));
		visualisers.add(new LastBellPerfectVisualiser(1.0));
		visualisers.add(new SimpleLADVisualiser());

		return visualisers;
	}

	@Override
	public void init()
	{
		super.init();
    fWindow = CAS.createNewCASWindow();
	}

	@Override
	public void start()
	{
		try
		{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run()
				{
					fWindow.open(CAS.this);
					System.out.println("New window opened with URL: "+getDocumentBase());
					if (NOWORCESTER)
					{
						String file = "short.txt";
						try
						{
							fWindow.loadFile(file);
						}
						catch (IOException e)
						{
							System.out.println("Failed to load file: "+file);
						}
					}
				}
			});
		}
		catch (Exception e)
		{
			System.out.println("Failed to start CAS: "+e);
		}
	}

	@Override
	public void stop()
	{
		fWindow.close();
		super.stop();
	}

	@Override
	public void destroy()
	{
		super.destroy();
		fWindow = null;
	}

	public void setTitle(String title)
	{
		getAppletContext().showStatus(title);
	}

	public void openFromStrikeData(final String strikeData, final String touchTitle)
	{
		if ( strikeData != null ) {
			if (!strikeData.isEmpty()) {
				try {
					fWindow.loadFromString(strikeData, touchTitle);
				} catch (IOException e) {
					// Mmmm ... not much to do here
				}
			}
		}
	}
	
	public void openFile()
	{
		//final String testData = "#. Lowndes: Version 2 (support comments in the file)\n#. Creator: Hawkear Version 0.6\n#. TranscriptionDate: 2013-03-05--20-29\n#. FirstBlowMs: 2830\nH 1 0X0000\nH 2 0X00e6\nH 3 0X024e\nH 4 0X032a\nH 5 0X0406\nH 6 0X0528\nH 7 0X05a0\nH 8 0X06a4\nH 9 0X07b2\nH O 0X08ac\nH E 0X09a6\nH T 0X0b04\nH 1 0X0b2c\nH 2 0X0bfe\nH 3 0X0d48\nH 4 0X0de8\nH 5 0X0ea6\nH 6 0X0f6e\nH 7 0X1036\nH 8 0X1112\nH 9 0X11a8\nH O 0X1270\nH E 0X1310\nH T 0X1496";
		final String touchTitle = "Stedman";
		
		openFromStrikeData(LOWNDES_TEST_DATA, touchTitle);
		
		/*
		Object[] files = readFileList().toArray();
		String filename = (String)JOptionPane.showInputDialog(this, "Choose file to open:", "Open striking file", JOptionPane.PLAIN_MESSAGE, null, files, files[0]);
		if (filename!=null)
		{
			try
			{
				fWindow.loadFile(filename);
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Failed to open file", JOptionPane.ERROR_MESSAGE);
			}
		}*/
	}

	public void openNewCASWindow()
	{
		URL u = getDocumentBase();
		System.out.println("Showing new window: "+u);
		getAppletContext().showDocument(u, "_blank");
	}

	public void openNewCASWindow(String fileToLoad)
	{
		URL appletPage = makePageURL(null, fileToLoad);
		if (appletPage!=null)
		{
			System.out.println("Showing new window: "+appletPage);
			getAppletContext().showDocument(appletPage, "_blank");
		}
	}

	private URL makePageURL(String page, String queryString)
	{
		URL currentPage = getDocumentBase();
		String path = currentPage.getPath();
		if (page!=null)
		{
			int i = path.lastIndexOf('/');
			if (i>=0)
				path = path.substring(0, i);
			path+= page;
		}
		if (queryString!=null)
			path+= queryString;
		try
		{
			return new URL(currentPage, path);
		}
		catch (MalformedURLException e)
		{
			System.out.println("Failed to create URL for new window: "+e);
		}
		return null;
	}

	@Override
	public void closeWindow()
	{
		URL closePage = makePageURL("close.html", null);
		if (closePage!=null)
		{
			fWindow.close();
			getAppletContext().showDocument(closePage, "_blank");
		}
	}

	public void openSummaryWindow()
	{
		URL summaryPage = makePageURL("summary.html", null);
		if (summaryPage!=null)
		{
			System.out.println("Showing summary window: "+summaryPage);
			getAppletContext().showDocument(summaryPage, "summary");
		}
	}

	public Reader getReader(String name) throws FileNotFoundException
	{
		InputStream in = getClass().getResourceAsStream("/"+name);
		if (in==null)
			throw new FileNotFoundException(name);
		return new InputStreamReader(in);
	}

	public void export()
	{
		// Not supported - can't save stuff.
		// Could open a text window to display I guess.

	}

	/**
	 * In applet mode, files.lst gives us the list of striking files we
	 * can open.
	 */
	private List<String> readFileList()
	{
		List<String> files = new ArrayList<String>();
		LineNumberReader in = null;
		try
		{
			in = new LineNumberReader(getReader(APPLET_FILE_LIST));
			String line = in.readLine();
			while (line!=null)
			{
				line = line.trim();
				if (line.length()>0)
					files.add(line);
				line = in.readLine();
			}
		}
		catch (IOException e)
		{
			System.out.println("Failed to read files list: "+e);
			files.add("peal.txt");
			files.add("short.txt");
			files.add("touch3.txt");
			files.add("touch5.txt");
		}
		finally
		{
			if (in!=null)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{	}
			}
		}
		return files;
	}
}
