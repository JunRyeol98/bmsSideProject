package com.side.bms.model.service;

import com.side.bms.model.dao.InventoryMapper;
import com.side.bms.model.dto.BookDTO;
import com.side.bms.model.dto.InventoryDTO;
import com.side.bms.model.dto.QuantityByBookDTO;
import com.side.bms.model.dto.QuantityByLocationDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.side.bms.common.Template.getSqlSession;

public class InventoryService {
    /***
     * 도서별 재고 조회 메서드
     * @return List<BookQuantityDTO>
     * 도서별 재고리스트 반환
     */
    public List<QuantityByBookDTO> selectBookQuantity() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        List<QuantityByBookDTO> bookQuantityList = inventoryMapper.selectBookQuantity();
        sqlSession.close();
        return bookQuantityList;
    }

    /***
     * 창고별 재고 조회 메서드
     * @return List<QuantityByLocationDTO>
     * 창고별 재고리스트 반환
     */
    public List<QuantityByLocationDTO> selectLocationQuantity() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        List<QuantityByLocationDTO> locationQuantityList = inventoryMapper.selectLocationQuantity();
        sqlSession.close();
        return locationQuantityList;
    }

    /***
     * 도서 입고 처리 메서드
     * @param inventoryDTO
     * @return int
     * 입고처리 성공시 추가되는 컬럼개수반환 (성공시 1 실패시 0)
     */
    public int insertInventory(InventoryDTO inventoryDTO) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        int result = 0;
        try {
            result = inventoryMapper.insertInventory(inventoryDTO);
            sqlSession.commit();

        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
            return result;
        }

    }

    /***
     * 도서 출고 처리 메서드
     * @param inventoryDTO
     * @return int
     * 출고처리 성공시 추가되는 컬럼개수반환 (성공시 1 실패시 0)
     */
    public int updateInventory(InventoryDTO inventoryDTO) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        int result = 0;
        try {
            result = inventoryMapper.updateInventory(inventoryDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
            return result;
        }
    }


    /***
     * 재고 이동 처리 메서드
     * @param inventoryDTO
     * @return int
     * 재고 이동 처리 성공시 추가되는 컬럼개수반환 (성공시 1 실패시 0)
     */
    public int moveInventory(InventoryDTO inventoryDTO) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        int result = 0;
        try {
            result = inventoryMapper.moveInventory(inventoryDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
            return result;
        }

    }
}
